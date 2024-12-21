package io.boshra.tmdb.shows

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.boshra.filmtime.data.api.tmdb.TmdbShowsRemoteSource
import io.boshra.filmtime.data.api.tmdb.TmdbShowsRemoteSource.Companion.PAGE_SIZE
import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.filmtime.data.model.toThrowable
import javax.inject.Inject

class ShowsPagingSource @Inject constructor(
  private val tmdbShowsRemoteSource: TmdbShowsRemoteSource,
) : PagingSource<Int, VideoThumbnail>() {

  override fun getRefreshKey(state: PagingState<Int, VideoThumbnail>): Int =
    STARTING_PAGE_INDEX

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VideoThumbnail> = try {
    val page = params.key ?: STARTING_PAGE_INDEX
    when (val response = fetchShows(page)) {
      is Result.Success -> {
        val list = response.data
        LoadResult.Page(
          data = list,
          prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
          nextKey = if (list.size < PAGE_SIZE) null else page + 1,
        )
      }
      is Result.Failure -> LoadResult.Error(response.error.toThrowable())
    }
  } catch (e: Exception) {
    LoadResult.Error(e)
  }

  private suspend fun fetchShows(page: Int): Result<List<VideoThumbnail>, GeneralError> =
    tmdbShowsRemoteSource.getTrendingShows(page)

  companion object {
    const val STARTING_PAGE_INDEX = 1
  }
}
