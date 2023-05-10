package com.example.mvvm.kotlin.movies.domain.usecase

import com.example.mvvm.kotlin.movies.domain.repo.MoviesRepo

class GetMovies(private val moviesRepo: MoviesRepo) {
    suspend operator fun invoke() = moviesRepo.getMovieFromRemote()
}