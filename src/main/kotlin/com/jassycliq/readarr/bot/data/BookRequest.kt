package com.jassycliq.readarr.bot.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookRequest(
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
    @SerialName("foreignBookId")
    val foreignBookId: String,
    @SerialName("genres")
    val genres: List<String>,
    @SerialName("grabbed")
    val grabbed: Boolean,
    @SerialName("id")
    val id: Int,
    @SerialName("images")
    val images: List<Image>,
    @SerialName("links")
    val links: List<Link>,
    @SerialName("monitored")
    val monitored: Boolean,
    @SerialName("pageCount")
    val pageCount: Int,
    @SerialName("ratings")
    val ratings: Ratings,
    @SerialName("releaseDate")
    val releaseDate: String,
    @SerialName("seriesTitle")
    val seriesTitle: String,
    @SerialName("statistics")
    val statistics: Statistics,
    @SerialName("title")
    val title: String,
    @SerialName("titleSlug")
    val titleSlug: String
) {
    @Serializable
    data class Author(
        @SerialName("addOptions")
        val addOptions: AddOptions,
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
        val images: List<Image>,
        @SerialName("links")
        val links: List<Link>,
        @SerialName("metadataProfileId")
        val metadataProfileId: Int,
        @SerialName("monitorNewItems")
        val monitorNewItems: String,
        @SerialName("monitored")
        val monitored: Boolean,
        @SerialName("overview")
        val overview: String,
        @SerialName("path")
        val path: String,
        @SerialName("qualityProfileId")
        val qualityProfileId: Int,
        @SerialName("ratings")
        val ratings: Ratings,
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
    ) {
        @Serializable
        data class AddOptions(
            @SerialName("booksToMonitor")
            val booksToMonitor: List<String>,
            @SerialName("monitor")
            val monitor: String,
            @SerialName("monitored")
            val monitored: Boolean,
            @SerialName("searchForMissingBooks")
            val searchForMissingBooks: Boolean
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
