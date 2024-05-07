plugins {
  id("io.boshra.filmtime.gradle.android.data")
}

android {
  namespace = "io.boshra.filmtime.data.api.tmdb"
}

dependencies {
  implementation(project(":data:network"))
}
