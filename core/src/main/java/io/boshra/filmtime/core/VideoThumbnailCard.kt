package io.boshra.filmtime.core

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import io.boshra.filmtime.data.model.VideoThumbnail

@Composable
fun VideoThumbnailCard(
  modifier: Modifier,
  videoThumbnail: VideoThumbnail,
  onClick: () -> Unit,
) {
  Card(
    onClick = onClick,
    modifier = modifier,
  ) {
    VideoThumbnailCardContent(videoThumbnail = videoThumbnail)
  }
}

@Composable
private fun VideoThumbnailCardContent(
  videoThumbnail: VideoThumbnail,
) {
  AsyncImage(
    model = videoThumbnail.posterUrl,
    contentDescription = videoThumbnail.title,
    modifier = Modifier.fillMaxSize(),
    contentScale = ContentScale.Crop,
  )
}
