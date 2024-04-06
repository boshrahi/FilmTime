package io.boshra.stream

import io.boshra.filmtime.data.model.StreamInfo
import kotlinx.coroutines.flow.Flow

interface GetStreamInfoUseCase {
  suspend operator fun invoke(): Flow<StreamInfo>
}
