package io.boshra.filmtime.domain.tmdb.movie

import io.boshra.filmtime.data.model.VideoThumbnail

interface GetMovieDetailsUseCase {
  suspend operator fun invoke(movieId: Int): VideoThumbnail
}
