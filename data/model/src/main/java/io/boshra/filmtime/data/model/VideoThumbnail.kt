package io.boshra.filmtime.data.model

data class VideoThumbnail(
  val ids: VideoId,
  val title: String,
  val posterUrl: String,
  val year: Int,
)

data class VideoId(
  val traktId: Int?,
  val tmdbId: Int?,
)

enum class VideoType {
  Movie,
  Show,
}

enum class VideoListType {
  Trending,
  Popular,
  TopRated,
  NowPlaying, // Movie Only
  Upcoming, // Movie Only
  OnTheAir, // Show Only
  AiringToday, // Show Only
}
