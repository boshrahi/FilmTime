package io.boshra.filmtime.data.api.tmdb

import io.boshra.filmtime.data.model.VideoDetail

interface TmdbMoviesRemoteSource {

  suspend fun getMovieDetails(movieId: Int): VideoDetail
}
