package io.boshra.filmtime.domain.tmdb.movie

import io.boshra.filmtime.data.model.VideoDetail

interface GetMovieDetailsUseCase {
  suspend operator fun invoke(movieId: Int): VideoDetail
}
