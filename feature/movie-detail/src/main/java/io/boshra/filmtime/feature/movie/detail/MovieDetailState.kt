package io.boshra.filmtime.feature.movie.detail

import io.boshra.filmtime.data.model.StreamInfo
import io.boshra.filmtime.data.model.VideoDetail

data class MovieDetailState(
  val isLoading: Boolean = false,
  val videoDetail: VideoDetail? = null,
  val isStreamLoading: Boolean = false,
  val streamInfo: StreamInfo? = null,
)
