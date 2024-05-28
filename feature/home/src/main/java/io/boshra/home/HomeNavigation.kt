package io.boshra.home

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.boshra.filmtime.data.model.VideoListType
import io.boshra.filmtime.data.model.VideoType

fun NavGraphBuilder.homeScreen(
  onVideoThumbnailClicked: (movieId: Int) -> Unit,
  onAllVideosClicked: (videoType: VideoType, videoList: VideoListType) -> Unit,
) {
  composable("home") {
    HomeScreen(
      viewModel = hiltViewModel(),
      onVideoThumbnailClick = { movieId ->
        onVideoThumbnailClicked(movieId)
      },
      onAllVideosClicked = { videoType, videoList ->
        onAllVideosClicked(videoType, videoList)
      },
    )
  }
}
