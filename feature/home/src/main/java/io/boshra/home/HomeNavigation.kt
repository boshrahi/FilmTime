package io.boshra.home

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.homeScreen(
  onVideoThumbnailClicked: (movieId: Int) -> Unit
){
  composable("home") {
    HomeScreen(
      viewModel = hiltViewModel(),
      onVideoThumbnailClick = { movieId ->
        onVideoThumbnailClicked(movieId)
      },
    )
  }
}
