package io.boshra.stream

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class StreamModule {

  @Binds
  abstract fun bindGetStreamInfoUseCase(
    getStreamInfoUseCaseImpl: FakeGetStreamInfoUseCaseImpl,
  ): GetStreamInfoUseCase
}
