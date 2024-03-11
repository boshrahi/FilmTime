package io.boshra.filmtime.feature.movie.detail

import io.boshra.filmtime.data.model.VideoThumbnail

data class MovieDetailState(
  val isLoading: Boolean = false,
  val videoThumbnail: VideoThumbnail? = null,
)
