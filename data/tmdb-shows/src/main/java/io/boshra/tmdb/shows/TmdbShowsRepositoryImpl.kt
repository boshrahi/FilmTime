package io.boshra.tmdb.shows

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import io.boshra.filmtime.data.api.tmdb.TmdbShowsRemoteSource
import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TmdbShowsRepositoryImpl @Inject constructor(
  private val remoteSourceTmdbShows: TmdbShowsRemoteSource,
) : TmdbShowsRepository {

  override suspend fun getTrendingShows(): Result<List<VideoThumbnail>, GeneralError> {
    return remoteSourceTmdbShows.getTrendingShows(page = 1)
  }

  override fun showsStream(): Flow<PagingData<VideoThumbnail>> {
    return Pager(
      config = PagingConfig(
        pageSize = TmdbShowsRemoteSource.PAGE_SIZE,
        enablePlaceholders = false,
      ),
      pagingSourceFactory = {
        ShowsPagingSource(
          tmdbShowsRemoteSource = remoteSourceTmdbShows,
        )
      },
    ).flow
  }
}
