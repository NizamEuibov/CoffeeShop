plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
}

android {
    namespace = "com.example.coffeeplus"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.coffeeplus"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildFeatures{
        viewBinding=true
    }
}

dependencies {

    implementation(libs.hilt.android)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.media3.common)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.material3.android)
    implementation(libs.material)
    implementation(libs.play.services.maps)
    kapt("androidx.room:room-compiler:2.6.1")
    implementation (libs.glide)
    annotationProcessor (libs.compiler)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.fragment.ktx.v162)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.config)
    implementation(libs.okhttp)
    implementation (libs.material.v190)
    implementation(libs.logging.interceptor)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v121)
    androidTestImplementation(libs.androidx.espresso.core.v361)
    implementation(libs.circleimageview)
    implementation (libs.exoplayer.ui)
    implementation (libs.exoplayer.core)
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.datasource.okhttp)
    implementation(libs.dexter)
    implementation(libs.coil)
    implementation (libs.ui)
    implementation (libs.androidx.material)
    implementation (libs.ui.tooling.preview)
    implementation (libs.androidx.lifecycle.runtime.ktx.v284)
    implementation (libs.androidx.activity.compose.v191)
}