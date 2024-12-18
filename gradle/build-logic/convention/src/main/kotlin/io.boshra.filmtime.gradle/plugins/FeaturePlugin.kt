package io.boshra.filmtime.gradle.plugins

import io.boshra.filmtime.gradle.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class FeaturePlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      pluginManager.apply {
        apply("io.boshra.filmtime.gradle.android.library")
        apply("io.boshra.filmtime.gradle.android.hilt")
      }

      dependencies {
        add("implementation", project(":data:model"))
        add("implementation", project(":core"))

        add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
        add("implementation", libs.findLibrary("lifecycle.runtime.compose").get())
        add("implementation", libs.findLibrary("lifecycle.viewmodel.compose").get())
        add("implementation", libs.findLibrary("coil-compose").get())
        add("implementation", libs.findLibrary("material3").get())

        add("testImplementation", libs.findLibrary("junit").get())
        add("androidTestImplementation", libs.findLibrary("androidx-test-ext-junit").get())
        add("androidTestImplementation", libs.findLibrary("espresso-core").get())
      }
    }
  }
}
