@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.kotlin)
}

android {
    namespace = "com.mobilebreakero.common_ui"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    configurations {
        named("implementation") {
            resolutionStrategy.failOnVersionConflict()
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures{
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {


    implementation(libs.core.ktx)
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.nav.fragment)
    implementation(libs.nav.ktx)
    implementation(libs.constraintlayout)

    implementation(project(mapOf("path" to ":navigation")))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}