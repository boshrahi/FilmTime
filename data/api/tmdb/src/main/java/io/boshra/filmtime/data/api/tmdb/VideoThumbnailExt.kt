package io.boshra.filmtime.data.api.tmdb

import io.boshra.filmtime.data.model.VideoId
import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.filmtime.data.network.TmdbMovieDetailsResponse

fun TmdbMovieDetailsResponse.toVideoThumbnail(): VideoThumbnail =
  VideoThumbnail(
    ids = VideoId(
      traktId = null,
      tmdbId = id
    ),
    title = title ?: "",
    posterUrl = posterPath ?: "",
    year = releaseDate?.take(4)?.toInt() ?: 0
  )
