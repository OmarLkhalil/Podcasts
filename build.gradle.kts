// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.org.kotlin) apply false
    alias(libs.plugins.com.android.library) apply false
    alias(libs.plugins.hilt) apply false


}
true // Needed to make the Suppress annotation work for the plugins block