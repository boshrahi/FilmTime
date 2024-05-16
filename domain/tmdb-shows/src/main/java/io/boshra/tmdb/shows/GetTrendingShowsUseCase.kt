package io.boshra.tmdb.shows

import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail
import kotlinx.coroutines.flow.Flow

interface GetTrendingShowsUseCase {

  operator fun invoke(): Flow<Result<List<VideoThumbnail>, GeneralError>>
}
