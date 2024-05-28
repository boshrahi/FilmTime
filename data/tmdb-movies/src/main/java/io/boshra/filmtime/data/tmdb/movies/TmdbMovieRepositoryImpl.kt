package io.boshra.filmtime.data.tmdb.movies

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import io.boshra.filmtime.data.api.tmdb.TmdbMoviesRemoteSource
import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoDetail
import io.boshra.filmtime.data.model.VideoThumbnail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class TmdbMovieRepositoryImpl @Inject constructor(
  private val tmdbMoviesRemoteSource: TmdbMoviesRemoteSource,
) : TmdbMovieRepository {
  override suspend fun getMovieDetails(movieId: Int): Result<VideoDetail, GeneralError> =
    tmdbMoviesRemoteSource.getMovieDetails(movieId)

  override suspend fun getTrendingMovies(): Result<List<VideoThumbnail>, GeneralError> =
    tmdbMoviesRemoteSource.getTrendingMovies(page = 1)

  override fun moviesStream(): Flow<PagingData<VideoThumbnail>> =
    Pager(
      config = PagingConfig(
        pageSize = TmdbMoviesRemoteSource.PAGE_SIZE,
        enablePlaceholders = false,
      ),
      pagingSourceFactory = {
        MoviesPagingSource(
          tmdbMoviesRemoteSource = tmdbMoviesRemoteSource,
        )
      },
    ).flow
}
