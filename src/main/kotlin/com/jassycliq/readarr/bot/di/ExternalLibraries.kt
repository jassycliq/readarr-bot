@file:OptIn(ExperimentalSerializationApi::class)

package com.jassycliq.readarr.bot.di

import com.jassycliq.readarr.bot.ReadarrApi
import de.jensklingenberg.ktorfit.Ktorfit
import dev.kord.core.Kord
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.api.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Module
import org.koin.core.annotation.Property
import org.koin.core.annotation.Singleton

@Module
class ExternalLibraries {

    @Singleton
    fun providesKord(@Property("READARR_BOT_DISCORD_TOKEN") discordToken: String): Kord {
        return runBlocking { Kord(discordToken) }
    }

    @Singleton
    fun providesReadarrAuthPlugin(
        @Property("READARR_BOT_READARR_API_TOKEN") apiToken: String,
    ): ClientPlugin<Unit> = createClientPlugin("ReadarrAuthPlugin") {
        onRequest { request, _ ->
            request.headers.append("X-Api-Key", apiToken)
        }
    }

    @Singleton
    fun providesKtorClient(readarrAuthPlugin: ClientPlugin<Unit>, ): HttpClient {
        return HttpClient(CIO) {
            install(readarrAuthPlugin)
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    explicitNulls = false
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
//            install(Logging) {
//                level = LogLevel.BODY
//            }
        }
    }

    @Singleton
    fun providesKtorfit(
        @Property("READARR_BOT_READARR_URL") serverUrl: String,
        @Property("READARR_BOT_READARR_PROTOCOL") protocol: String,
        ktorClient: HttpClient,
    ): Ktorfit =
        Ktorfit.Builder()
            .baseUrl("$protocol://$serverUrl")
            .httpClient(ktorClient)
            .build()

    @Singleton
    fun providesReadarrApi(ktorfit: Ktorfit): ReadarrApi =
        ktorfit.create<ReadarrApi>()
}
