plugins {
  id("io.boshra.filmtime.gradle.android.data")
}

android {
  namespace = "io.boshra.filmtime.data.tmdb.movies"
}

dependencies {

  implementation(project(":data:api:tmdb"))
  api(libs.paging.runtime)
}
