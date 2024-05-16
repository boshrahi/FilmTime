package io.boshra.player

import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

fun NavGraphBuilder.playerScreen() {
  composable(
    "player/{stream_url}",
    arguments = listOf(
      navArgument("stream_url") {
        type = NavType.StringType
      },
    ),
  ) { backStackEntry ->
    val streamUrl = backStackEntry.arguments?.getString("stream_url")
    VideoPlayer(uri = Uri.parse(Uri.decode(streamUrl)))
  }
}

fun NavController.navigateToPlayer(streamUrl: String) {
  val encode = Uri.encode(streamUrl)
  navigate("player/$encode")
}
