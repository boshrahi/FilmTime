package io.boshra.tmdb.shows.impl

import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.tmdb.shows.GetTrendingShowsUseCase
import io.boshra.tmdb.shows.TmdbShowsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTrendingShowsUseCaseImpl @Inject constructor(
  private val tmdbShowsRepository: TmdbShowsRepository,
) : GetTrendingShowsUseCase {

  override fun invoke(): Flow<Result<List<VideoThumbnail>, GeneralError>> =
    flow {
      emit(tmdbShowsRepository.getTrendingShows())
    }
}
