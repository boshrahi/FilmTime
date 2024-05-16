package io.boshra.tmdb.shows

import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail

interface TmdbShowsRepository {

  suspend fun getTrendingMovies(): Result<List<VideoThumbnail>, GeneralError>
}
