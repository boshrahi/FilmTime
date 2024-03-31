package io.boshra.filmtime.feature.movie.detail

import io.boshra.filmtime.data.model.VideoDetail

data class MovieDetailState(
  val isLoading: Boolean = false,
  val videoDetail: VideoDetail? = null,
)
