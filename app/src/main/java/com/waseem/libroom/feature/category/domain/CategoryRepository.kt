package com.waseem.libroom.feature.category.domain

import com.waseem.libroom.core.SResult

interface CategoryRepository {
    fun getAllCategories(): SResult<List<BookCategory>>

    fun getTopCategories(): SResult<List<BookCategory>>
}