plugins {
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.kotlinAndroid)
  kotlin("kapt")
  alias(libs.plugins.hilt.android)
}

android {
  namespace = "io.boshra.home"
  compileSdk = 34

  defaultConfig {
    minSdk = 27

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    buildFeatures {
      compose = true
    }

    composeOptions {
      kotlinCompilerExtensionVersion = "1.5.1"
    }
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

  implementation(project(":domain:tmdb-movie"))
  implementation(project(":data:model"))

  implementation(libs.core.ktx)
  implementation(libs.appcompat)
  implementation(libs.material)

  implementation(platform(libs.compose.bom))
  implementation(libs.ui)
  implementation(libs.ui.graphics)
  implementation(libs.ui.tooling.preview)
  implementation(libs.material3)
  implementation(libs.lifecycle.viewmodel.compose)
  implementation(libs.lifecycle.runtime.compose)
  implementation(libs.hilt.android)
  implementation(libs.coil.compose)

  kapt(libs.dagger.hilt.android.compiler)

  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.test.ext.junit)
  androidTestImplementation(libs.espresso.core)
}