plugins {
  id("io.boshra.filmtime.gradle.android.feature")
  id("io.boshra.filmtime.gradle.android.library.compose")
}

android {
  namespace = "io.boshra.filmtime.feature.player"
}

dependencies {

  implementation(project(":domain:tmdb-movie"))
  implementation(project(":domain:tmdb-shows"))
  implementation(libs.androidx.media3.exoplayer)
  implementation(libs.androidx.media3.hls)
  implementation(libs.androidx.media3.ui)
  api(libs.paging.compose)
}
