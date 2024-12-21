plugins {
  id("io.boshra.filmtime.gradle.android.domain")
}

android {
  namespace = "io.boshra.filmtime.domain.tmdb.show"
}

dependencies {
  implementation(project(":data:tmdb-shows"))
  api(libs.paging.runtime)
}
