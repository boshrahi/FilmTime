package io.boshra.home

import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.filmtime.data.model.VideoType

data class HomeUiState(
  val isLoading: Boolean,
  val isRefreshing: Boolean,
  val videoSections: List<VideoSections> = emptyList(),
)

data class VideoSections(
  val type: VideoType,
  val title: String,
  val items: List<VideoThumbnail> = emptyList(),
)
