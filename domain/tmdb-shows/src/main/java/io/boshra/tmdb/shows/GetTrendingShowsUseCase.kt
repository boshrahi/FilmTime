package io.boshra.tmdb.shows

import kotlinx.coroutines.flow.Flow
import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.filmtime.data.model.Result

interface GetTrendingShowsUseCase {

  operator fun invoke(): Flow<Result<List<VideoThumbnail>, GeneralError>>

}
