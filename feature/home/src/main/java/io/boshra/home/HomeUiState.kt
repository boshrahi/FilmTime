package io.boshra.home

import io.boshra.filmtime.data.model.VideoThumbnail

data class HomeUiState(
  val isLoading: Boolean,
  val isRefreshing: Boolean,
  val videoSections: List<VideoSections> = emptyList(),
)
data class VideoSections(
  val title: String,
  val items: List<VideoThumbnail> = emptyList(),
)
