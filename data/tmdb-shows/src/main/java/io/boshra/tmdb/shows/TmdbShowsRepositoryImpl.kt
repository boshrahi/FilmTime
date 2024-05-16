package io.boshra.tmdb.shows

import io.boshra.filmtime.data.api.tmdb.TmdbShowsRemoteSource
import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoThumbnail
import javax.inject.Inject

class TmdbShowsRepositoryImpl @Inject constructor(
  private val remoteSourceTmdbShows: TmdbShowsRemoteSource,
) : TmdbShowsRepository {

  override suspend fun getTrendingMovies(): Result<List<VideoThumbnail>, GeneralError> {
    return remoteSourceTmdbShows.getTrendingShows()
  }
}
