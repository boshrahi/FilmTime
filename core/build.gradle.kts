plugins {
  id("io.boshra.filmtime.gradle.android.library")
  id("io.boshra.filmtime.gradle.android.library.compose")
}

android {
  namespace = "io.boshra.filmtime.core"
}

dependencies {
  implementation(project(":data:model"))

  implementation(libs.material3)
  api(libs.coil.compose)
}
