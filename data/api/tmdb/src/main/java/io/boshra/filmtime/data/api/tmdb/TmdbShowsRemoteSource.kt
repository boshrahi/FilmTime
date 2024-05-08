package io.boshra.filmtime.data.api.tmdb

import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail

interface TmdbShowsRemoteSource {
  suspend fun getTrendingShows(): Result<List<VideoThumbnail>, GeneralError>
}
