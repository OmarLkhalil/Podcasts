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

rootProject.name = "Podcasts"
include(":app")
include(":core:domain")
include(":core:data")
include(":ui:home")
include(":ui:favorite")
include(":ui:search")
include(":ui:settings")
include(":common-ui")
include(":ui:podcast")
