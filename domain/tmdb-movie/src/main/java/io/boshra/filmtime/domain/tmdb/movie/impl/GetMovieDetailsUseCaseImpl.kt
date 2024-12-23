package io.boshra.filmtime.domain.tmdb.movie.impl

import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoDetail
import io.boshra.filmtime.data.tmdb.movies.TmdbMovieRepository
import io.boshra.filmtime.domain.tmdb.movie.GetMovieDetailsUseCase
import javax.inject.Inject

internal class GetMovieDetailsUseCaseImpl @Inject constructor(
  private val tmdbMovieRepository: TmdbMovieRepository,
) : GetMovieDetailsUseCase {

  override suspend fun invoke(movieId: Int): Result<VideoDetail, GeneralError> =
    tmdbMovieRepository.getMovieDetails(movieId)
}
