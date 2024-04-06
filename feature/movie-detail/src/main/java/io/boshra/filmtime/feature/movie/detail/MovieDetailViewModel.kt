package io.boshra.filmtime.feature.movie.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.boshra.filmtime.domain.tmdb.movie.GetMovieDetailsUseCase
import io.boshra.stream.FakeGetStreamInfoUseCaseImpl
import io.boshra.stream.GetStreamInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
  private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
  private val getStreamInfoUseCase: GetStreamInfoUseCase,
): ViewModel() {

  private val videoId: Int = savedStateHandle["movie_id"] ?: throw IllegalStateException("movie_id is required")
  private val _state: MutableStateFlow<MovieDetailState> = MutableStateFlow(MovieDetailState())
  val state = _state.asStateFlow()

  init {
    load(videoId)
  }
  private fun load(videoId: Int) {
    viewModelScope.launch {
      _state.value = _state.value.copy(isLoading = true)
      val result = getMovieDetailsUseCase(videoId)
      _state.value = _state.value.copy(videoDetail = result, isLoading = false)
    }
  }

  fun loadStreamInfo() = viewModelScope.launch {
    _state.value = _state.value.copy(isStreamLoading = true)
    getStreamInfoUseCase()
      .onEach { streamInfo ->
        _state.value = _state.value.copy(streamInfo = streamInfo, isStreamLoading = false)
      }
      .collect()
  }
}
