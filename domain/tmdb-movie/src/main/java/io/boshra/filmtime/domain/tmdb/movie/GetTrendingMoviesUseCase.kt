package io.boshra.filmtime.domain.tmdb.movie

import io.boshra.filmtime.data.model.VideoThumbnail
import kotlinx.coroutines.flow.Flow

interface GetTrendingMoviesUseCase {
  suspend operator fun invoke(): Flow<List<VideoThumbnail>>
}
