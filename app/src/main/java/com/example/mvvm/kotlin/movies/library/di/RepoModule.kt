package com.example.mvvm.kotlin.movies.library.di

import com.example.mvvm.kotlin.movies.data.remote.ApiService
import com.example.mvvm.kotlin.movies.data.repo.MoviesRepoImpl
import com.example.mvvm.kotlin.movies.domain.repo.MoviesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService): MoviesRepo {
        return MoviesRepoImpl(apiService)
    }
}