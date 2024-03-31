package io.boshra.filmtime.domain.tmdb.movie

import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.filmtime.data.tmdb.movies.TmdbMovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTrendingMovieUseCaseImpl @Inject constructor(
  private val tmdbMovieRepository: TmdbMovieRepository
): GetTrendingMoviesUseCase {
  override suspend fun invoke(): Flow<List<VideoThumbnail>> =
    flow {
      emit(tmdbMovieRepository.getTrendingMovies())
    }
}
