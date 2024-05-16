package io.boshra.filmtime.domain.tmdb.movie

import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail
import kotlinx.coroutines.flow.Flow

interface GetTrendingMoviesUseCase {
  operator fun invoke(): Flow<Result<List<VideoThumbnail>, GeneralError>>
}
