package io.boshra.video.thumbnail.grid

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import dagger.hilt.android.lifecycle.HiltViewModel
import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.filmtime.data.model.VideoType
import io.boshra.filmtime.domain.tmdb.movie.ObserverMoviesStreamUseCase
import io.boshra.tmdb.shows.ObserverShowsStreamUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class VideoThumbnailGridViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
  getMoviesStreamUseCase: ObserverMoviesStreamUseCase,
  getShowsStreamUseCase: ObserverShowsStreamUseCase,
) : ViewModel() {

  private val args = VideoThumbnailGridArgs(savedStateHandle)
  private val videoType = args.videoType
  private val listType = args.listType

  private val _state: MutableStateFlow<VideoThumbnailGridUiStatus> =
    MutableStateFlow(VideoThumbnailGridUiStatus())
  val state = _state.asStateFlow()

  val pagedList: Flow<PagingData<VideoThumbnail>> =
    when (videoType) {
      VideoType.Movie -> getMoviesStreamUseCase(listType)
      VideoType.Show -> getShowsStreamUseCase(listType)
    }.map { pagingData ->
      val items = mutableListOf<VideoThumbnail>()
      pagingData.filter { videoThumbnail ->
        items.contains(videoThumbnail)
          .not()
          .also { shouldAdd ->
            if (shouldAdd) {
              items.add(videoThumbnail)
            }
          }
      }
    }.cachedIn(viewModelScope)
}
