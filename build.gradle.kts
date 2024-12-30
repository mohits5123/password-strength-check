// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}

buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        // Directly reference the Android Gradle Plugin and Kotlin plugin
        classpath(libs.android.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin.v180)
    }
}