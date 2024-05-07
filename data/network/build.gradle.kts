plugins {
  id("io.boshra.filmtime.gradle.android.data")
  id("kotlinx-serialization")
}

android {
  namespace = "io.boshra.filmtime.data.network"

  defaultConfig {
    buildConfigField("String", "TMDB_API_KEY", "\"${System.getenv("FILM_TIME_TMDB_API_KEY")}\"")
  }

  buildFeatures {
    buildConfig = true
  }
}

dependencies {

  implementation(libs.retrofit)
  implementation(libs.kotlinx.serialization.json)
  implementation(libs.kotlinx.serialization.json.converter)
}
