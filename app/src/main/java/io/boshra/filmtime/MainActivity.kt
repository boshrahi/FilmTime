package io.boshra.filmtime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import io.boshra.filmtime.feature.movie.detail.MovieDetailViewModel
import io.boshra.filmtime.feature.movie.detail.MovieDetailsScreen
import io.boshra.filmtime.ui.theme.FilmTimeTheme
import io.boshra.home.HomeScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  private val viewModel by viewModels<MovieDetailViewModel>()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      FilmTimeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colorScheme.background,
        ) {
          val navController = rememberNavController()
          NavHost(
            navController = navController,
            startDestination = "home",
          ) {
            composable("home") {
              HomeScreen(
                viewModel = hiltViewModel(),
                onVideoThumbnailClick = { movieId ->
                  navController.navigate("detail/$movieId")
                },
              )
            }
            composable(
              "detail/{movie_id}",
              arguments = listOf(
                navArgument("movie_id") {
                  type = NavType.IntType
                },
              ),
            ) {
              MovieDetailsScreen(viewModel = hiltViewModel())
            }
          }
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier,
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  FilmTimeTheme {
    Greeting("Android")
  }
}
