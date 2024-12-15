plugins {
  id("io.boshra.filmtime.gradle.android.domain")
}

android {
  namespace = "io.boshra.filmtime.domain.tmdb.movie"
}

dependencies {
  implementation(project(":data:tmdb-movies"))
  api(libs.paging.runtime)
}
