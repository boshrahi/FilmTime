@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.kotlinx.serialization)
  kotlin("kapt")
  alias(libs.plugins.hilt.android)
}

android {
  namespace = "io.boshra.filmtime.data.network"
  compileSdk = 34

  defaultConfig {
    minSdk = 27

    buildConfigField("String", "TMDB_API_KEY", "\"${System.getenv("FILM_TIME_TMDB_API_KEY")}\"")

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }
  buildFeatures {
    buildConfig = true
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro",
      )
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
}

dependencies {

  implementation(libs.core.ktx)
  implementation(libs.appcompat)
  implementation(libs.material)
  implementation(libs.retrofit)
  implementation(libs.kotlinx.serialization.json)
  implementation(libs.kotlinx.serialization.json.converter)
  implementation(libs.hilt.android)
  kapt(libs.dagger.hilt.android.compiler)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.test.ext.junit)
  androidTestImplementation(libs.espresso.core)
}
