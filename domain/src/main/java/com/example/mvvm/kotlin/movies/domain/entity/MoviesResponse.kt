package com.example.mvvm.kotlin.movies.domain.entity

data class MoviesResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)