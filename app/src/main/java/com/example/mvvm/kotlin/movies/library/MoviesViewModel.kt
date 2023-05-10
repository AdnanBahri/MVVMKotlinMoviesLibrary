package com.example.mvvm.kotlin.movies.library

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.kotlin.movies.domain.entity.MoviesResponse
import com.example.mvvm.kotlin.movies.domain.usecase.GetMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMovies
) : ViewModel() {
    private val _movies: MutableStateFlow<MoviesResponse?> = MutableStateFlow(null)
    val movies: StateFlow<MoviesResponse?> = _movies
    fun getMovies() {
        viewModelScope.launch {
            try {
                _movies.value = getMoviesUseCase()
            } catch (e: Exception) {
                Log.e("MovieViewModel", e.message.toString())
            }
        }

    }
}