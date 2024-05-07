plugins {
  id("io.boshra.filmtime.gradle.android.feature")
  id("io.boshra.filmtime.gradle.android.library.compose")
}

android {
  namespace = "io.boshra.filmtime.feature.movie.detail"
}

dependencies {

  implementation(project(":domain:tmdb-movie"))
  implementation(project(":domain:stream"))
  implementation(project(":data:model"))

  implementation(libs.lottie.compose)
}
