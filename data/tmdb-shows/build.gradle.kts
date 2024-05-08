plugins {
  id("io.boshra.filmtime.gradle.android.data")
}

android {
  namespace = "io.boshra.filmtime.data.tmdb.shows"
}

dependencies {

  implementation(project(":data:api:tmdb"))
}
