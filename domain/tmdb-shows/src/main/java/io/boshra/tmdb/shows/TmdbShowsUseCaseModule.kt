package io.boshra.tmdb.shows

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.boshra.tmdb.shows.impl.GetTrendingShowsUseCaseImpl
import io.boshra.tmdb.shows.impl.ObserverShowsStreamUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
internal abstract class TmdbShowsUseCaseModule {

  @Binds
  abstract fun bindGetTrendingShowsUseCase(
    impl: GetTrendingShowsUseCaseImpl,
  ): GetTrendingShowsUseCase

  @Binds
  abstract fun bindStreamShowsUseCase(
    impl: ObserverShowsStreamUseCaseImpl,
  ): ObserverShowsStreamUseCase
}
