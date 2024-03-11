package io.boshra.filmtime.feature.movie.detail

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MovieDetailsScreen(
  viewModel: MovieDetailViewModel
) {
  val state by viewModel.state.collectAsStateWithLifecycle()

  if (state.isLoading){
    CircularProgressIndicator()
  }else {
    Text(text = state.videoThumbnail?.title ?: "Loading...")
  }

}
