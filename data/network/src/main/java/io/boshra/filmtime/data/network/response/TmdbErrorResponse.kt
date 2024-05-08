package io.boshra.filmtime.data.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class TmdbErrorResponse(
  @SerialName("status_code")
  val statusCode: Int,
  @SerialName("status_message")
  val statusMessage: String,
)
