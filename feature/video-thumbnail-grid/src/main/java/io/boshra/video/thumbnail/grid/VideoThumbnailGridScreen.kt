package io.boshra.video.thumbnail.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import io.boshra.filmtime.core.VideoThumbnailCard
import io.boshra.filmtime.data.model.VideoThumbnail

@Composable
fun VideoThumbnailGridScreen(
  onMovieClick: (tmdbId: Int) -> Unit,
  onShowClick: (tmdbId: Int) -> Unit,
  onBack: () -> Unit,
) {
  val viewModel = hiltViewModel<VideoThumbnailGridViewModel>()
  val pagedList = viewModel.pagedList.collectAsLazyPagingItems()

  LazyVerticalGrid(
    columns = GridCells.Fixed(3),
    contentPadding = PaddingValues(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier.padding(8.dp),
  ) {
    items(pagedList.itemCount) { index ->
      val item = pagedList[index]
      item?.let {
        CustomListItem(item)
      }
    }
    pagedList.apply {
      when {
        loadState.refresh is LoadState.Loading -> {
          item { CircularProgressIndicator() }
        }
        loadState.append is LoadState.Loading -> {
          item { CircularProgressIndicator() }
        }
        loadState.append is LoadState.Error -> {
          item { Text(text = "Error") }
        }
      }
    }
  }
}

@Composable
fun CustomListItem(item: VideoThumbnail?) {
  // Display your item content here
  VideoThumbnailCard(
    modifier = Modifier
      .testTag("discover_carousel_item")
      .fillMaxHeight()
      .aspectRatio(2 / 3f),
    videoThumbnail = item!!,
    onClick = {
      item.ids.tmdbId?.let {
        // TODO
        // onVideoThumbnailClick(it)
      }
    },
  )
}
