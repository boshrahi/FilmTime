package io.boshra.tmdb.shows

import androidx.paging.PagingData
import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail
import kotlinx.coroutines.flow.Flow

interface TmdbShowsRepository {

  suspend fun getTrendingShows(): Result<List<VideoThumbnail>, GeneralError>
  fun showsStream(): Flow<PagingData<VideoThumbnail>>
}
