package io.boshra.filmtime.domain.tmdb.movie

import io.boshra.filmtime.data.model.GeneralError
import io.boshra.filmtime.data.model.Result
import io.boshra.filmtime.data.model.VideoDetail

interface GetMovieDetailsUseCase {
  suspend operator fun invoke(movieId: Int): Result<VideoDetail, GeneralError>
}
