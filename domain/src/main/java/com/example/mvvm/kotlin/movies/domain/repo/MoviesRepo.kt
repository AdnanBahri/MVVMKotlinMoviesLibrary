package com.example.mvvm.kotlin.movies.domain.repo

import com.example.mvvm.kotlin.movies.domain.entity.MoviesResponse

interface MoviesRepo {
    suspend fun getMovieFromRemote(): MoviesResponse
}