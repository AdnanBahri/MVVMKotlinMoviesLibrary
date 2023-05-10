package com.example.mvvm.kotlin.movies.data.repo

import com.example.mvvm.kotlin.movies.data.remote.ApiService
import com.example.mvvm.kotlin.movies.domain.entity.MoviesResponse
import com.example.mvvm.kotlin.movies.domain.repo.MoviesRepo

class MoviesRepoImpl(private val apiService: ApiService) : MoviesRepo {
    // Todo : update the api_key
    override suspend fun getMovieFromRemote(): MoviesResponse = apiService.getMovies("api_key")
}