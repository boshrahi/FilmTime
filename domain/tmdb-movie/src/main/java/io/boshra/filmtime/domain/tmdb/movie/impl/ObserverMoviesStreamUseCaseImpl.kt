package io.boshra.filmtime.domain.tmdb.movie.impl

import androidx.paging.PagingData
import io.boshra.filmtime.data.model.VideoListType
import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.filmtime.data.tmdb.movies.TmdbMovieRepository
import io.boshra.filmtime.domain.tmdb.movie.ObserverMoviesStreamUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserverMoviesStreamUseCaseImpl @Inject constructor(
  private val tmdbMovieRepository: TmdbMovieRepository,
) : ObserverMoviesStreamUseCase {

  override fun invoke(videoListType: VideoListType): Flow<PagingData<VideoThumbnail>> {
    return tmdbMovieRepository.moviesStream()
  }
}
