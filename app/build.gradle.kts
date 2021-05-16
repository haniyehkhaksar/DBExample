plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")
    defaultConfig {
        applicationId = "io.github.haniyehkhaksar.dbexample"
        minSdkVersion(16)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    kotlinOptions {
        val options = this as? org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options?.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    packagingOptions {
        exclude("META-INF/atomicfu.kotlin_module")
    }

}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.0")

    // Support libraries
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")

    // Android KTX
    implementation("androidx.core:core-ktx:1.3.2")

    // UI
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.fragment:fragment-ktx:1.3.3")

    // Coroutines for getting off the UI thread
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0-RC")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0-RC")

    // Arch components
    // ViewModel and LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0-alpha01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0-alpha01")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.4.0-alpha01")
    // Lifecycles only (without ViewModel or LiveData)
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha01")

    // Saved state module for ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.4.0-alpha01")

    // Room components
    implementation ("androidx.room:room-ktx:2.3.0")
    kapt ("androidx.room:room-compiler:2.3.0")

    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.4.0-alpha01")

    //View
    implementation("androidx.recyclerview:recyclerview:1.2.0")
    implementation("androidx.cardview:cardview:1.0.0")

    // Dagger 2
    kapt("com.google.dagger:dagger-compiler:2.35.1")
    kapt("com.google.dagger:dagger-android-processor:2.35.1")

    implementation("com.google.dagger:dagger:2.35.1")
    implementation("com.google.dagger:dagger-android:2.35.1")
    implementation("com.google.dagger:dagger-android-support:2.35.1")

}

