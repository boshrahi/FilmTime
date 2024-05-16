package io.boshra.filmtime.feature.movie.detail

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

fun NavGraphBuilder.movieDetailScreen(
  onStreamReady: (streamUrl: String) -> Unit,
) {
  composable(
    "detail/{movie_id}",
    arguments = listOf(
      navArgument("movie_id") {
        type = NavType.IntType
      },
    ),
  ) {
    MovieDetailsScreen(viewModel = hiltViewModel()) { streamUrl ->
      onStreamReady(streamUrl)
    }
  }
}

fun NavController.navigateToMovieDetail(movieId: Int) {
  navigate("detail/$movieId")
}
