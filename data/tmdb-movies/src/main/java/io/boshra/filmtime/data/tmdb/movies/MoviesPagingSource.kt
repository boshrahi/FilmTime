package io.boshra.filmtime.data.tmdb.movies

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.boshra.filmtime.data.api.tmdb.TmdbMoviesRemoteSource
import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.filmtime.data.model.toThrowable

class MoviesPagingSource(
  private val tmdbMoviesRemoteSource: TmdbMoviesRemoteSource,
) : PagingSource<Int, VideoThumbnail>() {

  override fun getRefreshKey(state: PagingState<Int, VideoThumbnail>): Int? =
    STARTING_PAGE_INDEX

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VideoThumbnail> = try {
    val page = params.key ?: STARTING_PAGE_INDEX
    when (val response = fetchMovies(page = page)) {
      is Result.Success -> {
        val movies = response.data
        LoadResult.Page(
          data = movies,
          prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
          nextKey = if (movies.size < PAGE_SIZE) null else page + 1,
        )
      }

      is Result.Failure -> LoadResult.Error(response.error.toThrowable())
    }
  } catch (e: Exception) {
    LoadResult.Error(e)
  }

  private suspend fun fetchMovies(page: Int): Result<List<VideoThumbnail>, GeneralError> {
    return tmdbMoviesRemoteSource.getTrendingMovies(page)
  }

  companion object {
    private const val STARTING_PAGE_INDEX = 1
    private const val PAGE_SIZE = TmdbMoviesRemoteSource.PAGE_SIZE
  }
}
