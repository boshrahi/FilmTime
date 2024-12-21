package io.boshra.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoType
import io.boshra.filmtime.domain.tmdb.movie.GetTrendingMoviesUseCase
import io.boshra.tmdb.shows.GetTrendingShowsUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase,
  private val getTrendingShowsUseCase: GetTrendingShowsUseCase,
) : ViewModel() {

  private val _state = MutableStateFlow(HomeUiState(isLoading = false, isRefreshing = false))
  val state = _state.asStateFlow()

  fun refreshData() {
    viewModelScope.launch {
      // Set refreshing state to true
      _state.update { it.copy(isRefreshing = true, videoSections = emptyList()) }

      // Parallel refresh of trending movies and shows
      val movieDeferred = async { getTrendingMovies() }
      val showDeferred = async { getTrendingShows() }

      // Wait for both to complete
      awaitAll(movieDeferred, showDeferred)

      // Set refreshing state to false
      _state.update { it.copy(isRefreshing = false) }
    }
  }

  init {
    getTrendingMovies()
    getTrendingShows()
  }

  private fun getTrendingShows() {
    viewModelScope.launch {
      getTrendingShowsUseCase()
        .onStart { _state.update { state -> state.copy(isLoading = true) } }
        .onCompletion {
          delay(1000L)
          _state.update { state -> state.copy(isLoading = false) }
        }
        .onEach { result ->
          when (result) {
            is Result.Success -> {
              _state.update { state ->
                state.copy(
                  videoSections = state.videoSections +
                    listOf(
                      VideoSections(
                        title = "Trending Shows",
                        type = VideoType.Show,
                        items = result.data,
                      ),
                    ),
                )
              }
            }

            is Result.Failure -> {
              // TODO handling
            }
          }
        }
        .collect()
    }
  }

  private fun getTrendingMovies() {
    viewModelScope.launch {
      getTrendingMoviesUseCase()
        .onStart { _state.update { state -> state.copy(isLoading = true) } }
        .onCompletion {
          delay(1000L)
          _state.update { state -> state.copy(isLoading = false) }
        }
        .onEach { result ->
          when (result) {
            is Result.Success -> {
              _state.update { state ->
                state.copy(
                  videoSections = state.videoSections +
                    listOf(
                      VideoSections(
                        title = "Trending Movies",
                        type = VideoType.Movie,
                        items = result.data,
                      ),
                    ),
                )
              }
            }

            is Result.Failure -> {
              // TODO handling
            }
          }
        }
        .collect()
    }
  }
}
