// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json              = Json { allowStructuredMapKeys = true }
// val videoListResponse = json.parse(VideoListResponse.serializer(), jsonString)

package io.boshra.filmtime.data.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TmdbMovieListResponse(
  val page: Long? = null,
  val results: List<TmdbMovieResultResponse>? = null,

  @SerialName("total_pages")
  val totalPages: Long? = null,

  @SerialName("total_results")
  val totalResults: Long? = null,
)

@Serializable
data class TmdbMovieResultResponse(
  val adult: Boolean? = null,

  @SerialName("backdrop_path")
  val backdropPath: String? = null,

  val id: Int? = null,
  val title: String? = null,

  @SerialName("original_language")
  val originalLanguage: String? = null,

  @SerialName("original_title")
  val originalTitle: String? = null,

  val overview: String? = null,

  @SerialName("poster_path")
  val posterPath: String? = null,

  @SerialName("media_type")
  val mediaType: String? = null,

  @SerialName("genre_ids")
  val genreIDS: List<Long>? = null,

  val popularity: Double? = null,

  @SerialName("release_date")
  val releaseDate: String? = null,

  val video: Boolean? = null,

  @SerialName("vote_average")
  val voteAverage: Double? = null,

  @SerialName("vote_count")
  val voteCount: Long? = null,
)
