package com.jassycliq.readarr.bot

import com.jassycliq.readarr.bot.data.SearchRequestItem
import dev.kord.core.Kord
import dev.kord.core.behavior.interaction.response.respond
import dev.kord.core.event.interaction.ChatInputCommandInteractionCreateEvent
import dev.kord.core.on
import dev.kord.gateway.builder.LoginBuilder
import dev.kord.rest.builder.interaction.int
import dev.kord.rest.builder.interaction.string
import dev.kord.rest.builder.interaction.subCommand
import dev.kord.rest.builder.message.modify.embed
import org.koin.core.annotation.Singleton
import org.koin.core.component.KoinComponent

@Singleton
internal class Commands constructor(
    private val kord: Kord,
    private val readarrService: ReadarrService,
) : KoinComponent {
    suspend fun login(builder: LoginBuilder.() -> Unit = {}) {
        kord.login(builder)
    }

    suspend fun registerSlashCommands(): Commands = apply {
        kord.createGlobalChatInputCommand(
            name = "search",
            description = "Command used to search for and add a specific book",
        ) {
            subCommand("name", "Search by book name") {
                string("name", "Name of book") {
                    required = true
                }
            }
            subCommand("id", "Search by book GoodReads ID") {
                int("id", "GoodReads ID of book") {
                    required = true
                }
            }
        }
    }

    suspend fun listenToSlashCommands(): Commands = apply {
        kord.on<ChatInputCommandInteractionCreateEvent> {
            val response = interaction.deferEphemeralResponse()
            val command = interaction.command
            val name = command.strings["name"]
            val id = command.integers["id"]

            val bookResults = when {
                name != null -> readarrService.searchBook(name)
                id != null -> readarrService.searchBook("edition:$id")
                else -> throw UnknownError()
            }

            bookResults.firstOrNull { it.item is SearchRequestItem.Book }?.apply {
                response.respond {
                    embed {
                        image = item.images.first().url
                        title = when (item) {
                            is SearchRequestItem.Author -> item.authorName
                            is SearchRequestItem.Book -> item.title
                        }
                        description = item.overview
                    }
                }
            }
        }
    }
}
