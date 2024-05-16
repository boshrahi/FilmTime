import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  `kotlin-dsl`
}

group = "io.boshra.filmtime.build"

// for building convention module
java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_17.toString()
  }
}

dependencies {
  compileOnly(libs.android.gradlePlugin)
  compileOnly(libs.kotlin.gradlePlugin)
}

tasks {
  validatePlugins {
    enableStricterValidation = true
    failOnWarning = true
  }
}

gradlePlugin {
  plugins {
    register("androidApplicationCompose") {
      id = "io.boshra.filmtime.gradle.android.application.compose"
      implementationClass = "io.boshra.filmtime.gradle.plugins.ApplicationComposePlugin"
    }
    register("androidApplication") {
      id = "io.boshra.filmtime.gradle.android.application"
      implementationClass = "io.boshra.filmtime.gradle.plugins.ApplicationPlugin"
    }
    register("androidLibraryCompose") {
      id = "io.boshra.filmtime.gradle.android.library.compose"
      implementationClass = "io.boshra.filmtime.gradle.plugins.LibraryComposePlugin"
    }
    register("androidLibrary") {
      id = "io.boshra.filmtime.gradle.android.library"
      implementationClass = "io.boshra.filmtime.gradle.plugins.LibraryPlugin"
    }
    register("androidFeature") {
      id = "io.boshra.filmtime.gradle.android.feature"
      implementationClass = "io.boshra.filmtime.gradle.plugins.FeaturePlugin"
    }
    register("androidData") {
      id = "io.boshra.filmtime.gradle.android.data"
      implementationClass = "io.boshra.filmtime.gradle.plugins.DataPlugin"
    }
    register("androidDomain") {
      id = "io.boshra.filmtime.gradle.android.domain"
      implementationClass = "io.boshra.filmtime.gradle.plugins.DomainPlugin"
    }
    register("androidHilt") {
      id = "io.boshra.filmtime.gradle.android.hilt"
      implementationClass = "io.boshra.filmtime.gradle.plugins.HiltPlugin"
    }
    register("jvmLibrary") {
      id = "io.boshra.filmtime.gradle.jvm.library"
      implementationClass = "io.boshra.filmtime.gradle.plugins.LibraryJvmPlugin"
    }
  }
}
