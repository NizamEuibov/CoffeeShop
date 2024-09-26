// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("androidx.navigation.safeargs") version "2.7.7" apply false
    id("com.google.dagger.hilt.android") version "2.46.1" apply false
    kotlin("kapt") version "1.9.10"
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin) apply false
}