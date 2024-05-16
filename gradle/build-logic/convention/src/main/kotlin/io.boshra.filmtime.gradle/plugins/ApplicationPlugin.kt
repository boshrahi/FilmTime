package io.boshra.filmtime.gradle.plugins

import com.android.build.api.dsl.ApplicationExtension
import io.boshra.filmtime.gradle.Versions
import io.boshra.filmtime.gradle.configureKotlinAndroid
import io.boshra.filmtime.gradle.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class ApplicationPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("com.android.application")
        apply("org.jetbrains.kotlin.android")

        apply("io.boshra.filmtime.gradle.android.application.compose")
        apply("io.boshra.filmtime.gradle.android.hilt")
      }

      extensions.configure<ApplicationExtension> {
        configureKotlinAndroid()

        defaultConfig {
          targetSdk = Versions.TARGET_SDK
        }
      }

      dependencies {
        add("testImplementation", libs.findLibrary("junit").get())
        add("androidTestImplementation", libs.findLibrary("androidx-test-ext-junit").get())
      }
    }
  }
}
