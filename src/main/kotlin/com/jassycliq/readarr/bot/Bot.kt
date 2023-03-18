package com.jassycliq.readarr.bot

import dev.kord.core.Kord
import org.koin.core.annotation.Property
import org.koin.core.annotation.Singleton

@Singleton
internal class Bot constructor(@Property("READARR_BOT_DISCORD_TOKEN") val discordToken: String) {
    private var kord: Kord? = null

    suspend operator fun invoke(): Kord {
        return when (kord) {
            null -> {
                Kord(discordToken).also { kord = it }
            }
            else -> kord!!
        }
    }
}
