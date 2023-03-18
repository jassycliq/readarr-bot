package com.jassycliq.readarr.bot

import com.jassycliq.readarr.bot.di.ExternalLibraries
import org.koin.core.context.startKoin
import org.koin.environmentProperties
import org.koin.fileProperties
import org.koin.ksp.generated.defaultModule
import org.koin.ksp.generated.module

suspend fun main() {
    val koin = startKoin {
        logger(Logger())
        // For development purposes using file properties but ultimately wanting to use env props
        environmentProperties()
        fileProperties()
        modules(
            listOf(
                defaultModule,
                ExternalLibraries().module,
            )
        )
    }.koin

    koin.get<Commands>()
        .registerSlashCommands()
        .listenToSlashCommands()
        .login()
}
