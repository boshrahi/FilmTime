plugins {
  id("io.boshra.filmtime.gradle.android.application")
}

android {
  namespace = "io.boshra.filmtime"

  defaultConfig {
    applicationId = "io.boshra.filmtime"
    versionCode = 1
    versionName = "1.0"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  implementation(project(":data:model"))
  implementation(project(":feature:movie-detail"))
  implementation(project(":feature:home"))
  implementation(project(":feature:player"))
  implementation(project(":feature:video-thumbnail-grid"))

  implementation(libs.material3)
  implementation(libs.androidx.navigation.compose)
}
