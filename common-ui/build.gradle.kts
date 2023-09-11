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

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(project(":ui:favorite"))
    implementation(project(":ui:home"))
    implementation(project(":ui:podcast"))
    implementation(project(":ui:search"))
    implementation(project(":ui:settings"))

    implementation(libs.core.ktx)
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.nav.version)
    implementation(libs.nav.version2)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}