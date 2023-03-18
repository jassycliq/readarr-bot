package com.jassycliq.readarr.bot

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.core.logger.Level
import org.koin.core.logger.Level.*
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE

internal class Logger(level: Level = ERROR) : Logger(level) {
    init {
        Napier.base(DebugAntilog("Kord =>"))
    }
    override fun display(level: Level, msg: MESSAGE) {
        when (level) {
            DEBUG -> Napier.d(message = msg)
            INFO -> Napier.i(message = msg)
            WARNING -> Napier.w(message = msg)
            ERROR -> Napier.e(message = msg)
            NONE -> {}
        }
    }
}
