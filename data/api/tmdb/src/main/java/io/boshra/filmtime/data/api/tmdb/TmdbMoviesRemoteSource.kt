package io.boshra.filmtime.data.api.tmdb

import io.boshra.filmtime.data.model.VideoThumbnail

interface TmdbMoviesRemoteSource {

  suspend fun getMovieDetails(movieId: Int): VideoThumbnail
}
