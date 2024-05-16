// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.androidApplication) apply false
  alias(libs.plugins.kotlinAndroid) apply false
  alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
  alias(libs.plugins.androidLibrary) apply false
  alias(libs.plugins.kotlinx.serialization) apply false
  alias(libs.plugins.hilt.android) apply false
  alias(libs.plugins.spotless)
}
spotless {
  kotlin {
    target("**/*.kt", "**/*.kts")
    targetExclude("$buildDir/**/*.kt", "bin/**/*.kt", "buildSrc/**/*.kt")
    // version, editorConfigPath, editorConfigOverride and customRuleSets are all optional
    ktlint().setEditorConfigPath("$rootDir/.editorconfig") // sample unusual placement
  }
}
true // Needed to make the Suppress annotation work for the plugins block
