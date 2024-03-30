package io.boshra.filmtime.data.api.tmdb

import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.filmtime.data.network.TmdbMoviesService
import javax.inject.Inject

internal class TmdbMoviesRemoteSourceImpl @Inject constructor(
  private val tmdbMoviesService: TmdbMoviesService,
) : TmdbMoviesRemoteSource {
  override suspend fun getMovieDetails(movieId: Int): VideoThumbnail =
    tmdbMoviesService.getMovieDetails(movieId).toVideoThumbnail()
}
