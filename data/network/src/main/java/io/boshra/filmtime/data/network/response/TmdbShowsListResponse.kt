package io.boshra.filmtime.data.network.response

import kotlinx.serialization.*

@Serializable
data class TmdbShowsListResponse (
  val page: Long? = null,
  val results: List<TmdbShowResultResponse>? = null,

  @SerialName("total_pages")
  val totalPages: Long? = null,

  @SerialName("total_results")
  val totalResults: Long? = null
)

@Serializable
data class TmdbShowResultResponse (
  @SerialName("backdrop_path")
  val backdropPath: String? = null,

  val id: Int? = null,

  @SerialName("original_name")
  val originalName: String? = null,

  val overview: String? = null,

  @SerialName("poster_path")
  val posterPath: String? = null,

  @SerialName("media_type")
  val mediaType: String? = null,

  val adult: Boolean? = null,
  val name: String? = null,

  @SerialName("original_language")
  val originalLanguage: String? = null,

  @SerialName("genre_ids")
  val genreIDS: List<Long>? = null,

  val popularity: Double? = null,

  @SerialName("first_air_date")
  val firstAirDate: String? = null,

  @SerialName("vote_average")
  val voteAverage: Double? = null,

  @SerialName("vote_count")
  val voteCount: Long? = null,

  @SerialName("origin_country")
  val originCountry: List<String>? = null
)


