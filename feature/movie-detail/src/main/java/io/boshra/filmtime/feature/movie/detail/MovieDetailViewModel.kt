package io.boshra.filmtime.feature.movie.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.boshra.filmtime.domain.tmdb.movie.GetMovieDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel(
  private val getMovieDetailsUseCase: GetMovieDetailsUseCase
): ViewModel() {

  private val _state: MutableStateFlow<MovieDetailState> = MutableStateFlow(MovieDetailState())
  val state = _state.asStateFlow()

  init {
    load(550)
  }
  fun load(videoId: Int) {
    viewModelScope.launch {
      _state.value = _state.value.copy(isLoading = true)
      val result = getMovieDetailsUseCase(videoId)
      _state.value = _state.value.copy(videoThumbnail = result, isLoading = false)
    }
  }
}
