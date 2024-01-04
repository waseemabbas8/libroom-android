package com.waseem.libroom.feature.category.domain

interface CategoryRepository {
    fun getAllCategories(): Result<List<BookCategory>>

    fun getTopCategories(): Result<List<BookCategory>>
}