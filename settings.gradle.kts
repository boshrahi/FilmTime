pluginManagement {
  includeBuild("gradle/build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FilmTime"
include(":app")
include(":data:model")
include(":data:network")
include(":data:api:tmdb")
include(":data:tmdb-movies")
include(":domain:tmdb-movie")
include(":feature:movie-detail")
include(":feature:home")
include(":domain:stream")
include(":feature:player")
include(":domain:tmdb-shows")
include(":data:tmdb-shows")
