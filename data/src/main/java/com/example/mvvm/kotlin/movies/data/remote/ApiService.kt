package com.example.mvvm.kotlin.movies.data.remote

import com.example.mvvm.kotlin.movies.domain.entity.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getMovies(@Query("api_key") api_key: String): MoviesResponse
}