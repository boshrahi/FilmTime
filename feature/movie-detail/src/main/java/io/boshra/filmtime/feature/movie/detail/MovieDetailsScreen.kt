package io.boshra.filmtime.feature.movie.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import io.boshra.filmtime.data.model.GeneralError

@Composable
fun MovieDetailsScreen(
  viewModel: MovieDetailViewModel,
  onStreamReady: (String) -> Unit,
) {
  val state by viewModel.state.collectAsStateWithLifecycle()
  val videoDetail = state.videoDetail
  val navigateToPlayer by viewModel.navigateToPlayer.collectAsStateWithLifecycle(initialValue = null)

  LaunchedEffect(key1 = navigateToPlayer) {
    navigateToPlayer?.let { streamUrl ->
      onStreamReady(streamUrl)
    }
  }
  if (state.isLoading) {
    CircularProgressIndicator()
  } else if (state.error != null) {
    ShowError(error = state.error!!, message = state.message!!, onRefresh = viewModel::load)
  } else if (videoDetail != null) {
    Column(
      modifier = Modifier
        .padding(16.dp)
        .verticalScroll(rememberScrollState()),
      verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
      AsyncImage(
        modifier = Modifier
          .width(200.dp)
          .height(300.dp),
        model = videoDetail.posterUrl,
        contentDescription = null,
      )

      AsyncImage(
        modifier = Modifier
          .fillMaxWidth()
          .height(300.dp),
        model = videoDetail.coverUrl,
        contentDescription = null,
      )
      Text(text = videoDetail.title)
      Text(text = videoDetail.description)

      Button(onClick = {
        viewModel.loadStreamInfo()
      }) {
        if (state.isStreamLoading) {
          CircularProgressIndicator(
            modifier = Modifier.size(16.dp),
            color = Color.White,
            strokeWidth = 2.dp,
          )
        } else {
          Text(text = "Play")
        }
      }

      Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
      ) {
        Text(text = "Year: ${videoDetail.year}")
        Text(text = "Original language: ${videoDetail.originalLanguage}")
        Text(text = videoDetail.spokenLanguage.joinToString(", "))
      }
      Text(text = "Genres")
      Text(text = videoDetail.genres.joinToString(", "))
    }
  }
}

@Composable
fun ShowError(error: GeneralError, message: String, onRefresh: () -> Unit) {
  val composition by rememberLottieComposition(
    LottieCompositionSpec.RawRes(
      if (error is GeneralError.NetworkError) {
        R.raw.network_lost
      } else {
        R.raw.not_found
      },
    ),
  )
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,

  ) {
    LottieAnimation(
      modifier = Modifier.scale(0.8f),
      composition = composition,
    )
    Spacer(modifier = Modifier.size(8.dp))
    Text(
      text = message,
      textAlign = TextAlign.Center,
      style = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
      ),
    )

    Spacer(modifier = Modifier.size(60.dp))
    Button(
      onClick = onRefresh,
    ) {
      Text(text = "Refresh")
    }
  }
}
