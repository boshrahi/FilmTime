package io.boshra.tmdb.shows.impl

import androidx.paging.PagingData
import io.boshra.filmtime.data.model.VideoListType
import io.boshra.filmtime.data.model.VideoThumbnail
import io.boshra.tmdb.shows.ObserverShowsStreamUseCase
import io.boshra.tmdb.shows.TmdbShowsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserverShowsStreamUseCaseImpl @Inject constructor(
  private val tmdbShowsRepository: TmdbShowsRepository,
) : ObserverShowsStreamUseCase {
  override fun invoke(videoListType: VideoListType): Flow<PagingData<VideoThumbnail>> {
    return tmdbShowsRepository.showsStream()
  }
}
