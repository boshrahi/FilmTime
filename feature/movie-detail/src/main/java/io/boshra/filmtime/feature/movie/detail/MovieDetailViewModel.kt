package io.boshra.filmtime.feature.movie.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.domain.tmdb.movie.GetMovieDetailsUseCase
import io.boshra.stream.GetStreamInfoUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
  private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
  private val getStreamInfoUseCase: GetStreamInfoUseCase,
) : ViewModel() {

  private val videoId: Int = savedStateHandle["movie_id"] ?: throw IllegalStateException("movie_id is required")
  private val _state: MutableStateFlow<MovieDetailState> = MutableStateFlow(MovieDetailState())
  val state = _state.asStateFlow()
  val navigateToPlayer = MutableSharedFlow<String?>()

  init {
    load()
  }
  fun load() = viewModelScope.launch {
    _state.value = _state.value.copy(isLoading = true)
    when (val result = getMovieDetailsUseCase(videoId)) {
      is Result.Success -> {
        _state.update { state ->
          state.copy(videoDetail = result.data, isLoading = false, error = null)
        }
      }

      is Result.Failure -> {
        when (result.error) {
          is GeneralError.ApiError -> {
            _state.update { state ->
              state.copy(
                error = result.error,
                message = (result.error as GeneralError.ApiError).message,
                isLoading = false,
              )
            }
          }

          GeneralError.NetworkError -> {
            _state.update { state ->
              state.copy(
                error = result.error,
                message = "No internet connection. Please check your network settings.",
                isLoading = false,
              )
            }
          }

          is GeneralError.UnknownError -> _state.update { state ->
            state.copy(
              error = result.error,
              message = (result.error as GeneralError.UnknownError).error.message,
              isLoading = false,
            )
          }
        }
      }
    }
  }

  fun loadStreamInfo() = viewModelScope.launch {
    _state.value = _state.value.copy(isStreamLoading = true)
    getStreamInfoUseCase()
      .onEach { streamInfo ->
        _state.value = _state.value.copy(streamInfo = streamInfo, isStreamLoading = false)
        navigateToPlayer.emit(streamInfo.url)
      }
      .collect()
  }
}
