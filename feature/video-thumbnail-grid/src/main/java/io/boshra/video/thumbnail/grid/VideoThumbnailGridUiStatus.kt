package io.boshra.video.thumbnail.grid

import io.boshra.filmtime.data.model.GeneralError

data class VideoThumbnailGridUiStatus(
  val isLoading: Boolean = false,
  val message: String? = null,
  val error: GeneralError? = null,
)
