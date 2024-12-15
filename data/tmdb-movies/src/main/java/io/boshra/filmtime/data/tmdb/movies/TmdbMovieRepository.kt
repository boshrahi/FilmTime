package io.boshra.filmtime.data.tmdb.movies

import androidx.paging.PagingData
import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoDetail
import io.boshra.filmtime.data.model.VideoThumbnail
import kotlinx.coroutines.flow.Flow

interface TmdbMovieRepository {

  suspend fun getMovieDetails(movieId: Int): Result<VideoDetail, GeneralError>
  suspend fun getTrendingMovies(): Result<List<VideoThumbnail>, GeneralError>
  fun moviesStream(): Flow<PagingData<VideoThumbnail>>
}
