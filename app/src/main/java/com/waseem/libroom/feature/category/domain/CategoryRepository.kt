package com.waseem.libroom.feature.category.domain

interface CategoryRepository {
    fun getCategories(): List<BookCategory>
}