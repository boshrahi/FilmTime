package io.boshra.filmtime.data.tmdb.movies

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class TmdbMoviesModule {

  @Binds
  abstract fun providesTmdbMovieRemoteSource(impl: TmdbMovieRepositoryImpl): TmdbMovieRepository
}
