pluginManagement {
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
