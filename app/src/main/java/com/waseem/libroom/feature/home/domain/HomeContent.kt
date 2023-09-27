package com.waseem.libroom.feature.home.domain

import com.waseem.libroom.feature.book.domain.Book

data class HomeContent (
    val recentReads: List<Book>,
    val popularBooks: List<Book>
)