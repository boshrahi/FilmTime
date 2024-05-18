package io.boshra.filmtime.gradle.plugins

import com.android.build.gradle.LibraryExtension
import io.boshra.filmtime.gradle.Versions
import io.boshra.filmtime.gradle.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class LibraryPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("com.android.library")
        apply("org.jetbrains.kotlin.android")
      }

      extensions.configure<LibraryExtension> {
        configureKotlinAndroid()
        defaultConfig.targetSdk = Versions.TARGET_SDK

        buildTypes {
          getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
              getDefaultProguardFile("proguard-android-optimize.txt"),
              "proguard-rules.pro",
            )
          }
        }
      }

      dependencies {
        add("testImplementation", kotlin("test"))
      }
    }
  }
}
