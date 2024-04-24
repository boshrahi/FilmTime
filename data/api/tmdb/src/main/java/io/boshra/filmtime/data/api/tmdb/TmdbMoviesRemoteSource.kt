package io.boshra.filmtime.data.api.tmdb

import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoDetail
import io.boshra.filmtime.data.model.VideoThumbnail


interface TmdbMoviesRemoteSource {

  suspend fun getMovieDetails(movieId: Int): Result<VideoDetail, GeneralError>
  suspend fun getTrendingMovies(): List<VideoThumbnail>
}
