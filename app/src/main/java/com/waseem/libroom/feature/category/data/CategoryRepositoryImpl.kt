package com.waseem.libroom.feature.category.data

import com.waseem.libroom.core.SResult
import com.waseem.libroom.feature.category.domain.BookCategory
import com.waseem.libroom.feature.category.domain.CategoryRepository
import java.util.UUID

class CategoryRepositoryImpl : CategoryRepository {
    override fun getAllCategories(): SResult<List<BookCategory>> {
        val categories = listOf(
            BookCategory(
                id = UUID.randomUUID().toString(),
                title = "Adventure",
                thumbnail = ""
            ),
            BookCategory(
                id = UUID.randomUUID().toString(),
                title = "Business",
                thumbnail = ""
            ),
            BookCategory(
                id = UUID.randomUUID().toString(),
                title = "Children",
                thumbnail = ""
            ),
            BookCategory(
                id = UUID.randomUUID().toString(),
                title = "Novel",
                thumbnail = ""
            ),
            BookCategory(
                id = UUID.randomUUID().toString(),
                title = "Fantasy",
                thumbnail = ""
            )
        )
        return SResult.success(categories)
    }

    override fun getTopCategories(): SResult<List<BookCategory>> {
        val categories = listOf(
            BookCategory(
                id = UUID.randomUUID().toString(),
                title = "Economy",
                thumbnail = "https://picsum.photos/id/20/500/300"
            ),
            BookCategory(
                id = UUID.randomUUID().toString(),
                title = "Business",
                thumbnail = "https://picsum.photos/id/26/500/300"
            ),
            BookCategory(
                id = UUID.randomUUID().toString(),
                title = "Children",
                thumbnail = "https://picsum.photos/id/367/500/300"
            ),
            BookCategory(
                id = UUID.randomUUID().toString(),
                title = "Novel",
                thumbnail = "https://picsum.photos/id/24/500/300"
            ),
            BookCategory(
                id = UUID.randomUUID().toString(),
                title = "Adventure",
                thumbnail = "https://picsum.photos/id/182/500/300"
            ),
            BookCategory(
                id = UUID.randomUUID().toString(),
                title = "Fantasy",
                thumbnail = "https://picsum.photos/id/144/500/300"
            )
        )
        return SResult.success(categories)
    }
}