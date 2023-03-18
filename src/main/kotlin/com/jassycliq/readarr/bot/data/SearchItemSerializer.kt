package com.jassycliq.readarr.bot.data

import kotlinx.serialization.*
import kotlinx.serialization.json.*

object SearchItemSerializer : JsonContentPolymorphicSerializer<SearchItem>(SearchItem::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<out SearchItem> {
        return when {
            "authorMetadataId" in element.jsonObject -> SearchRequestItem.Author.serializer()
            "title" in element.jsonObject -> SearchRequestItem.Book.serializer()
            else -> throw Exception("Serializer not found")
        }
    }
}
