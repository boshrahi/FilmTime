plugins {
  id("io.boshra.filmtime.gradle.android.feature")
  id("io.boshra.filmtime.gradle.android.library.compose")
}

android {
  namespace = "io.boshra.filmtime.feature.home"
}

dependencies {

  implementation(project(":domain:tmdb-movie"))
  implementation(project(":domain:tmdb-shows"))
}
