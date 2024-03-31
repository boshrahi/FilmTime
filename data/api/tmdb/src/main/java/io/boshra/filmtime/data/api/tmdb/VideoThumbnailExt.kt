package io.boshra.filmtime.data.api.tmdb

import io.boshra.filmtime.data.model.VideoDetail
import io.boshra.filmtime.data.model.VideoId
import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.filmtime.data.network.TmdbMovieDetailsResponse

private val TMDB_BASE_IMAGE_URL = "https://image.tmdb.org/t/p/original/"
fun TmdbMovieDetailsResponse.toVideoThumbnail(): VideoThumbnail =
  VideoThumbnail(
    ids = VideoId(
      traktId = null,
      tmdbId = id,
    ),
    title = title ?: "",
    posterUrl = posterPath ?: "",
    year = releaseDate?.take(4)?.toInt() ?: 0,
  )

fun TmdbMovieDetailsResponse.toVideoDetail(): VideoDetail =
  VideoDetail(
    ids = VideoId(
      traktId = null,
      tmdbId = id,
    ),
    title = title ?: "",
    posterUrl = if(!posterPath.isNullOrBlank()) TMDB_BASE_IMAGE_URL.plus(posterPath) else "",
    year = releaseDate?.take(4)?.toInt() ?: 0,
    genres = genres?.map { it.name } ?: listOf(),
    originalLanguage = originalLanguage,
    spokenLanguage = spokenLanguages?.map { it.englishName ?: "" }?.filter { it.isNotEmpty() }
      ?: listOf(),
    description = overview ?: "",
    tagLine = tagline,
    coverUrl = if(!backdropPath.isNullOrBlank()) TMDB_BASE_IMAGE_URL.plus(backdropPath) else "",
  )

