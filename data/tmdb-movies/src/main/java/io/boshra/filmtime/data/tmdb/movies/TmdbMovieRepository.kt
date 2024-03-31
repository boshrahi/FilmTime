package io.boshra.filmtime.data.tmdb.movies

import io.boshra.filmtime.data.model.VideoDetail
import io.boshra.filmtime.data.model.VideoThumbnail

interface TmdbMovieRepository {

  suspend fun getMovieDetails(movieId: Int): VideoDetail
}
