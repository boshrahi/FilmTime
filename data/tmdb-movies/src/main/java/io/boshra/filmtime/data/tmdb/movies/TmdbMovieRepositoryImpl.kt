package io.boshra.filmtime.data.tmdb.movies

import io.boshra.filmtime.data.api.tmdb.TmdbMoviesRemoteSource
import io.boshra.filmtime.data.model.VideoDetail
import io.boshra.filmtime.data.model.VideoThumbnail
import javax.inject.Inject

internal class TmdbMovieRepositoryImpl @Inject constructor(
  private val tmdbMoviesRemoteSource: TmdbMoviesRemoteSource
) : TmdbMovieRepository {
  override suspend fun getMovieDetails(movieId: Int): VideoDetail =
    tmdbMoviesRemoteSource.getMovieDetails(movieId)
}
