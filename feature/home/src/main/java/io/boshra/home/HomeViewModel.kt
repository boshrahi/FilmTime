package io.boshra.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.boshra.filmtime.domain.tmdb.movie.GetTrendingMoviesUseCase
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
) : ViewModel() {

  private val _state = MutableStateFlow(HomeUiState(isLoading = false))
  val state = _state.asStateFlow()

  init {
    viewModelScope.launch {
      getTrendingMoviesUseCase()
        .onStart { _state.update { state -> state.copy(isLoading = true) } }
        .onCompletion { _state.update { state -> state.copy(isLoading = false) } }
        .onEach {
          _state.update { state ->
            state.copy(videoSections = state.videoSections +
              listOf(VideoSections(title = "Trending Movies", it))) }
        }
        .collect()
    }
  }
}
