package io.boshra.tmdb.shows

import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTrendingShowsUseCaseImpl @Inject constructor(
  private val tmdbShowsRepository: TmdbShowsRepository,
) : GetTrendingShowsUseCase {

  override fun invoke(): Flow<Result<List<VideoThumbnail>, GeneralError>> =
    flow {
      emit(tmdbShowsRepository.getTrendingMovies())
    }
}
