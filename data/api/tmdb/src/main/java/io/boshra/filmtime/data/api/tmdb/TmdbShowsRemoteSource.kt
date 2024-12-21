package io.boshra.filmtime.data.api.tmdb

import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail

interface TmdbShowsRemoteSource {
  suspend fun getTrendingShows(page: Int): Result<List<VideoThumbnail>, GeneralError>

  companion object {
    const val PAGE_SIZE = 20 // TMDB API default page size
  }
}
