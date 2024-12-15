@file:OptIn(ExperimentalMaterialApi::class)

package io.boshra.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.boshra.filmtime.data.model.VideoThumbnail

@Composable
fun HomeScreen(
  viewModel: HomeViewModel,
  onVideoThumbnailClick: (tmdbMovieId: Int) -> Unit,
) {
  val state by viewModel.state.collectAsStateWithLifecycle()

  // PullRefreshState for managing refresh state
  val pullRefreshState = rememberPullRefreshState(
    refreshing = state.isRefreshing,
    onRefresh = { viewModel.refreshData() }
  )

  Box(modifier = Modifier.pullRefresh(pullRefreshState)) {
    if (state.isLoading) {
      CircularProgressIndicator(
        modifier = Modifier.wrapContentSize().align(Alignment.Center)
      )
    } else {
      LazyColumn(
        contentPadding = PaddingValues(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        items(state.videoSections) { videoSection ->
          VideoSectionRow(
            title = videoSection.title,
            items = videoSection.items,
            onVideoThumbnailClick = {
              onVideoThumbnailClick(it)
            },
          )
        }
      }
    }
  }
  // PullRefreshIndicator for the refresh UI
  Box(
    modifier = Modifier
      .fillMaxSize()
      .pullRefresh(pullRefreshState)
  ) {
    // Your content (e.g., LazyColumn, CircularProgressIndicator, etc.)

    PullRefreshIndicator(
      refreshing = state.isRefreshing,
      state = pullRefreshState,
      modifier = Modifier.align(Alignment.TopCenter) // Correct alignment
    )
  }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VideoSectionRow(
  title: String,
  items: List<VideoThumbnail>,
  onVideoThumbnailClick: (tmdbMovieId: Int) -> Unit,
) {
  Column {
    Row(
      modifier = Modifier
        .clickable { }
        .padding(16.dp),
    ) {
      Text(
        modifier = Modifier.weight(1f),
        text = title,
        style = MaterialTheme.typography.titleMedium,
      )
      Icon(
        imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
        contentDescription = "Open section",
      )
    }

    LazyRow(
      modifier = Modifier
        .height(200.dp)
        .fillMaxWidth(),
      contentPadding = PaddingValues(horizontal = 16.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      items(items) { item ->
        VideoThumbnailCard(
          modifier = Modifier
            .testTag("discover_carousel_item")
            .animateItemPlacement()
            .fillParentMaxHeight()
            .aspectRatio(2 / 3f),
          videoThumbnail = item,
          onClick = {
            item.ids.tmdbId?.let {
              onVideoThumbnailClick(it)
            }
          },
        )
      }
    }
  }
}
