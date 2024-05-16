package io.boshra.filmtime.gradle.plugins

import io.boshra.filmtime.gradle.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class DomainPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      pluginManager.apply {
        apply("io.boshra.filmtime.gradle.android.library")
        apply("io.boshra.filmtime.gradle.android.hilt")
      }

      dependencies {
        add("implementation", project(":data:model"))
        add("testImplementation", libs.findLibrary("junit").get())
        add("androidTestImplementation", libs.findLibrary("androidx-test-ext-junit").get())
      }
    }
  }
}
