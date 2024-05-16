package io.boshra.filmtime.domain.tmdb.movie

import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.filmtime.data.tmdb.movies.TmdbMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTrendingMovieUseCaseImpl @Inject constructor(
  private val tmdbMovieRepository: TmdbMovieRepository,
) : GetTrendingMoviesUseCase {
  override fun invoke(): Flow<Result<List<VideoThumbnail>, GeneralError>> =
    flow {
      emit(tmdbMovieRepository.getTrendingMovies())
    }
}
