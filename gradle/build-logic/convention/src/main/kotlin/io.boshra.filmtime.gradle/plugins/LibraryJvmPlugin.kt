package io.boshra.filmtime.gradle.plugins

import io.boshra.filmtime.gradle.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

class LibraryJvmPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("org.jetbrains.kotlin.jvm")
      }
      configureKotlinJvm()
    }
  }
}
