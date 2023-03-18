package com.jassycliq.readarr.bot

import org.koin.core.context.startKoin
import org.koin.environmentProperties
import org.koin.fileProperties
import org.koin.ksp.generated.defaultModule
import org.koin.ksp.generated.module

suspend fun main() {
    val koin = startKoin {
        logger(Logger())
        environmentProperties()
        fileProperties()
        modules(
            listOf(
                defaultModule,
                Network().module,
            )
        )
    }.koin

    koin.get<BotCommands>()
        .registerSlashCommands()
        .listenToSlashCommands()
        .login()
}
