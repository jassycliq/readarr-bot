package com.jassycliq.readarr.bot.data

import com.jassycliq.readarr.bot.data.SearchRequestItem.Image
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
sealed class SearchItem {
    abstract val images: List<Image>
    abstract val overview: String
}

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class SearchRequestItem(
    @SerialName("foreignId")
    val foreignId: String,
    @Serializable(with = SearchItemSerializer::class)
    @JsonNames("book", "author")
    val item: SearchItem,
    @SerialName("id")
    val id: Int,
) {

    @Serializable
    data class Author(
        @SerialName("added")
        val added: String,
        @SerialName("authorMetadataId")
        val authorMetadataId: Int,
        @SerialName("authorName")
        val authorName: String,
        @SerialName("authorNameLastFirst")
        val authorNameLastFirst: String,
        @SerialName("cleanName")
        val cleanName: String,
        @SerialName("ended")
        val ended: Boolean,
        @SerialName("foreignAuthorId")
        val foreignAuthorId: String,
        @SerialName("genres")
        val genres: List<String>,
        @SerialName("id")
        val id: Int,
        @SerialName("images")
        override val images: List<Image>,
        @SerialName("links")
        val links: List<Link>,
        @SerialName("metadataProfileId")
        val metadataProfileId: Int,
        @SerialName("monitorNewItems")
        val monitorNewItems: String,
        @SerialName("monitored")
        val monitored: Boolean,
        @SerialName("overview")
        override val overview: String,
        @SerialName("path")
        val path: String,
        @SerialName("qualityProfileId")
        val qualityProfileId: Int,
        @SerialName("ratings")
        val ratings: Ratings,
        @SerialName("remotePoster")
        val remotePoster: String? = null,
        @SerialName("sortName")
        val sortName: String,
        @SerialName("sortNameLastFirst")
        val sortNameLastFirst: String,
        @SerialName("statistics")
        val statistics: Statistics,
        @SerialName("status")
        val status: String,
        @SerialName("tags")
        val tags: List<String>,
        @SerialName("titleSlug")
        val titleSlug: String
    ) : SearchItem()

    @Serializable
    data class Book(
        @SerialName("added")
        val added: String,
        @SerialName("anyEditionOk")
        val anyEditionOk: Boolean,
        @SerialName("author")
        val author: Author,
        @SerialName("authorId")
        val authorId: Int,
        @SerialName("authorTitle")
        val authorTitle: String,
        @SerialName("disambiguation")
        val disambiguation: String,
        @SerialName("editions")
        val editions: List<Edition>,
        @SerialName("foreignBookId")
        val foreignBookId: String,
        @SerialName("genres")
        val genres: List<String>,
        @SerialName("grabbed")
        val grabbed: Boolean,
        @SerialName("id")
        val id: Int,
        @SerialName("images")
        override val images: List<Image>,
        @SerialName("links")
        val links: List<Link>,
        @SerialName("monitored")
        val monitored: Boolean,
        @SerialName("overview")
        override val overview: String,
        @SerialName("pageCount")
        val pageCount: Int,
        @SerialName("ratings")
        val ratings: Ratings,
        @SerialName("releaseDate")
        val releaseDate: String,
        @SerialName("remoteCover")
        val remoteCover: String,
        @SerialName("seriesTitle")
        val seriesTitle: String,
        @SerialName("title")
        val title: String,
        @SerialName("titleSlug")
        val titleSlug: String
    ) : SearchItem()

    @Serializable
    data class Edition(
        @SerialName("asin")
        val asin: String? = null,
        @SerialName("bookId")
        val bookId: Int,
        @SerialName("disambiguation")
        val disambiguation: String,
        @SerialName("foreignEditionId")
        val foreignEditionId: String,
        @SerialName("format")
        val format: String,
        @SerialName("grabbed")
        val grabbed: Boolean,
        @SerialName("id")
        val id: Int,
        @SerialName("images")
        val images: List<Image>,
        @SerialName("isEbook")
        val isEbook: Boolean,
        @SerialName("isbn13")
        val isbn13: String? = null,
        @SerialName("language")
        val language: String,
        @SerialName("links")
        val links: List<Link>,
        @SerialName("manualAdd")
        val manualAdd: Boolean,
        @SerialName("monitored")
        val monitored: Boolean,
        @SerialName("overview")
        val overview: String,
        @SerialName("pageCount")
        val pageCount: Int,
        @SerialName("publisher")
        val publisher: String,
        @SerialName("ratings")
        val ratings: Ratings,
        @SerialName("releaseDate")
        val releaseDate: String,
        @SerialName("title")
        val title: String,
        @SerialName("titleSlug")
        val titleSlug: String
    )

    @Serializable
    data class Image(
        @SerialName("coverType")
        val coverType: String,
        @SerialName("extension")
        val extension: String,
        @SerialName("url")
        val url: String
    )

    @Serializable
    data class Link(
        @SerialName("name")
        val name: String,
        @SerialName("url")
        val url: String
    )

    @Serializable
    data class Ratings(
        @SerialName("popularity")
        val popularity: Double,
        @SerialName("value")
        val value: Double,
        @SerialName("votes")
        val votes: Int
    )

    @Serializable
    data class Statistics(
        @SerialName("availableBookCount")
        val availableBookCount: Int,
        @SerialName("bookCount")
        val bookCount: Int,
        @SerialName("bookFileCount")
        val bookFileCount: Int,
        @SerialName("percentOfBooks")
        val percentOfBooks: Int,
        @SerialName("sizeOnDisk")
        val sizeOnDisk: Int,
        @SerialName("totalBookCount")
        val totalBookCount: Int
    )

}
