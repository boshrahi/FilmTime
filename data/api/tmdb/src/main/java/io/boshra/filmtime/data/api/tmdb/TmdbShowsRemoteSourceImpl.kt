package io.boshra.filmtime.data.api.tmdb

import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.filmtime.data.network.TmdbShowsService
import io.boshra.filmtime.data.network.adapter.NetworkResponse
import javax.inject.Inject

class TmdbShowsRemoteSourceImpl @Inject constructor(
  private val tmdbShowsService: TmdbShowsService,
) : TmdbShowsRemoteSource {

  override suspend fun getTrendingShows(): Result<List<VideoThumbnail>, GeneralError> =
    when (val result = tmdbShowsService.getTrendingShows()) {
      is NetworkResponse.Success -> {
        val videoDetailResponse = result.body
        if (videoDetailResponse == null) {
          Result.Failure(GeneralError.UnknownError(Throwable("trending shows response is null")))
        } else {
          Result.Success(videoDetailResponse.results?.map { it.toVideoThumbnail() }.orEmpty())
        }
      }
      is NetworkResponse.ApiError -> {
        val errorResponse = result.body
        Result.Failure(GeneralError.ApiError(errorResponse.statusMessage, errorResponse.statusCode))
      }

      is NetworkResponse.NetworkError -> Result.Failure(GeneralError.NetworkError)
      is NetworkResponse.UnknownError -> Result.Failure(GeneralError.UnknownError(result.error))
    }
}
