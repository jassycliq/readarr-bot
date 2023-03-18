package com.jassycliq.readarr.bot

import com.jassycliq.readarr.bot.data.SearchRequestItem
import org.koin.core.annotation.Singleton

@Singleton
class ReadarrService constructor(private val readarrApi: ReadarrApi) {

    suspend fun searchBook(bookName: String): List<SearchRequestItem> {
        return readarrApi.searchBook(bookName = bookName)
    }
}
