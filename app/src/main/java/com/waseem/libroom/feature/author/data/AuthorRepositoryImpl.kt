package com.waseem.libroom.feature.author.data

import com.waseem.libroom.feature.author.domain.Author
import com.waseem.libroom.feature.author.domain.AuthorRepository
import java.util.UUID

class AuthorRepositoryImpl : AuthorRepository {
    override suspend fun getAuthors(): Result<List<Author>> {
        val authors = listOf(
            Author(
                id = UUID.randomUUID().toString(),
                name = "Stephen King",
                image = "https://covers.openlibrary.org/a/id/7127409-M.jpg"
            ),
            Author(
                id = UUID.randomUUID().toString(),
                name = "George R. Martin",
                image = "https://covers.openlibrary.org/a/id/6387401-M.jpg"
            ),
            Author(
                id = UUID.randomUUID().toString(),
                name = "E. L. James",
                image = "https://covers.openlibrary.org/a/id/14362742-M.jpg"
            ),
            Author(
                id = UUID.randomUUID().toString(),
                name = "E. B. White",
                image = "https://covers.openlibrary.org/a/id/6390049-M.jpg"
            ),
            Author(
                id = UUID.randomUUID().toString(),
                name = "Neil Gaiman",
                image = "https://covers.openlibrary.org/a/id/7277125-M.jpg"
            ),
            Author(
                id = UUID.randomUUID().toString(),
                name = "Dennis Wheatley",
                image = "https://covers.openlibrary.org/a/id/6882587-M.jpg"
            )
        )
        return Result.success(authors)
    }

}