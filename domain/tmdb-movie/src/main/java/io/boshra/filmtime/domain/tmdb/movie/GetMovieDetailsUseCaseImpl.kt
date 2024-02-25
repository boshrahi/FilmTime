package io.boshra.filmtime.domain.tmdb.movie

import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.filmtime.data.tmdb.movies.TmdbMovieRepository

internal class GetMovieDetailsUseCaseImpl(
  private val tmdbMovieRepository: TmdbMovieRepository,
) : GetMovieDetailsUseCase {

  override suspend fun invoke(movieId: Int): VideoThumbnail =
    tmdbMovieRepository.getMovieDetails(movieId)
}
