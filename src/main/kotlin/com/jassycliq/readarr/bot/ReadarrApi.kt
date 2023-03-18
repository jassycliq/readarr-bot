package com.jassycliq.readarr.bot

import com.jassycliq.readarr.bot.data.SearchRequestItem
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query


interface ReadarrApi {

    @GET("api/v1/search")
    suspend fun searchBook(@Query("term") bookName: String): List<SearchRequestItem>

}
