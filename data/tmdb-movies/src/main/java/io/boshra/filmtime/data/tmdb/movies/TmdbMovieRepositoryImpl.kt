package io.boshra.filmtime.data.tmdb.movies

import io.boshra.filmtime.data.api.tmdb.TmdbMoviesRemoteSource
import io.boshra.filmtime.data.model.VideoThumbnail

internal class TmdbMovieRepositoryImpl(
  private val tmdbMoviesRemoteSource: TmdbMoviesRemoteSource
) : TmdbMovieRepository {
  override suspend fun getMovieDetails(movieId: Int): VideoThumbnail =
    tmdbMoviesRemoteSource.getMovieDetails(movieId)
}
