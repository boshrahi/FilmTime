package io.boshra.home

import io.boshra.filmtime.data.model.VideoThumbnail

data class HomeUiState(
  val isLoading: Boolean,
  val items: List<VideoThumbnail> = emptyList()
)
