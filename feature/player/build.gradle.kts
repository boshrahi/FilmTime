plugins {
  id("io.boshra.filmtime.gradle.android.feature")
  id("io.boshra.filmtime.gradle.android.library.compose")
}

android {
  namespace = "io.boshra.filmtime.feature.player"
}

dependencies {

  implementation(libs.androidx.media3.exoplayer)
  implementation(libs.androidx.media3.hls)
  implementation(libs.androidx.media3.ui)
}
