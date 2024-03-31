package io.boshra.filmtime.domain.tmdb.movie

import io.boshra.filmtime.data.model.VideoDetail
import io.boshra.filmtime.data.tmdb.movies.TmdbMovieRepository
import javax.inject.Inject

internal class GetMovieDetailsUseCaseImpl @Inject constructor(
  private val tmdbMovieRepository: TmdbMovieRepository,
) : GetMovieDetailsUseCase {

  override suspend fun invoke(movieId: Int): VideoDetail =
    tmdbMovieRepository.getMovieDetails(movieId)
}
