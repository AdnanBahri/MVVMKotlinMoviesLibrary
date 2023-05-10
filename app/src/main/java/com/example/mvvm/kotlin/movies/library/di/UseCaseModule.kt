package com.example.mvvm.kotlin.movies.library.di

import com.example.mvvm.kotlin.movies.domain.repo.MoviesRepo
import com.example.mvvm.kotlin.movies.domain.usecase.GetMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCase(moviesRepo: MoviesRepo): GetMovies {
        return GetMovies(moviesRepo)
    }
}