package io.boshra.stream

import io.boshra.filmtime.data.model.StreamInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeGetStreamInfoUseCaseImpl @Inject constructor(): GetStreamInfoUseCase {
  override suspend fun invoke(): Flow<StreamInfo> = flow {
    delay(1000L)
    emit(StreamInfo(url = "https://music.youtube.com/watch?v=mrONr6j3WMw"))
  }

}
