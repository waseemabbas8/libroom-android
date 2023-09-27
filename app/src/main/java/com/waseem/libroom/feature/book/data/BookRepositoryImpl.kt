package com.waseem.libroom.feature.book.data

import com.waseem.libroom.core.SResult
import com.waseem.libroom.feature.book.domain.Book
import com.waseem.libroom.feature.book.domain.BookRepository
import com.waseem.libroom.feature.home.domain.HomeContent
import java.util.UUID

class BookRepositoryImpl : BookRepository {
    override suspend fun getPopularBooks(): SResult<List<Book>> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecentReads(): SResult<List<Book>> {
        TODO("Not yet implemented")
    }

    override suspend fun getHomeContent(): SResult<HomeContent> {
        val recentReads = listOf(
            Book(
                id = UUID.randomUUID().toString(),
                title = "The Bane Chronicles",
                authorName = "Maureen Johnson",
                cover = "https://covers.openlibrary.org/b/id/13151170-L.jpg"
            ),
            Book(
                id = UUID.randomUUID().toString(),
                title = "Koralina",
                authorName = "Neil Gaiman",
                cover = "https://covers.openlibrary.org/b/id/12634691-L.jpg"
            ),
            Book(
                id = UUID.randomUUID().toString(),
                title = "Court of Mist and Fury",
                authorName = "Sarah J. Maas",
                cover = "https://covers.openlibrary.org/b/id/14416194-L.jpg"
            ),
            Book(
                id = UUID.randomUUID().toString(),
                title = "Red, White & Royal Blue",
                authorName = "Casey McQuiston",
                cover = "https://covers.openlibrary.org/b/id/9171544-L.jpg"
            ),
            Book(
                id = UUID.randomUUID().toString(),
                title = "Twisted Lies",
                authorName = "Ana Huang",
                cover = "https://covers.openlibrary.org/b/id/12816871-L.jpg"
            ),
            Book(
                id = UUID.randomUUID().toString(),
                title = "Fourth Wing",
                authorName = "Rebecca Yarros",
                cover = "https://covers.openlibrary.org/b/id/14407898-L.jpg"
            ),
            Book(
                id = UUID.randomUUID().toString(),
                title = "Surrendered Single",
                authorName = "Laura Doyle",
                cover = "https://covers.openlibrary.org/b/id/471953-L.jpg"
            )
        )
        val popular = listOf(
            Book(
                id = UUID.randomUUID().toString(),
                title = "Fifty Shades of Grey",
                authorName = "E. L. James",
                cover = "https://covers.openlibrary.org/b/id/10740111-L.jpg"
            ),
            Book(
                id = UUID.randomUUID().toString(),
                title = "Court of Mist and Fury",
                authorName = "Sarah J. Maas",
                cover = "https://covers.openlibrary.org/b/id/14416194-L.jpg"
            ),
            Book(
                id = UUID.randomUUID().toString(),
                title = "Surrendered Single",
                authorName = "Laura Doyle",
                cover = "https://covers.openlibrary.org/b/id/471953-L.jpg"
            ),
            Book(
                id = UUID.randomUUID().toString(),
                title = "The River Devil",
                authorName = "Diane Whiteside",
                cover = "https://covers.openlibrary.org/b/id/505653-M.jpg"
            )
        )
        return SResult.success(HomeContent(recentReads, popular))
    }
}