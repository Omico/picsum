/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.gradle.project

import com.android.build.api.AndroidPluginVersion
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DynamicFeatureExtension
import com.android.build.api.dsl.LibraryExtension
import me.omico.consensus.api.dsl.consensus
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getOrNull
import java.io.File

internal typealias AndroidCommonExtension = CommonExtension<*, *, *, *, *, *>
internal typealias AndroidApplicationExtension = ApplicationExtension
internal typealias AndroidLibraryExtension = LibraryExtension
internal typealias AndroidDynamicFeatureExtension = DynamicFeatureExtension

internal fun Project.configureAndroidCommonExtension(block: AndroidCommonExtension.() -> Unit): Unit =
    extensions.configure("android", block)

internal fun Project.configureAndroidApplicationExtension(block: AndroidApplicationExtension.() -> Unit): Unit =
    extensions.configure("android", block)

internal fun Project.configureAndroidLibraryExtension(block: AndroidLibraryExtension.() -> Unit): Unit =
    extensions.configure("android", block)

internal fun Project.configureAndroidDynamicFeatureExtension(block: AndroidDynamicFeatureExtension.() -> Unit): Unit =
    extensions.configure("android", block)

internal fun Project.configureAndroidCommonExtension(
    domain: String,
    compileSdk: Int,
    minSdk: Int,
    namespace: String = "$domain.${name.replace("-", ".")}",
    javaVersion: JavaVersion = JavaVersion.toVersion(PROJECT_JAVA_VERSION),
    coreLibraryDesugaringDependency: Any,
) {
    checkMinimalSupportedAndroidGradlePluginVersion()
    configureAndroidCommonExtension {
        this.namespace = namespace
        this.compileSdk = compileSdk
        defaultConfig {
            this.minSdk = minSdk
        }
        compileOptions {
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
            isCoreLibraryDesugaringEnabled = true
        }
    }
    dependencies.add("coreLibraryDesugaring", coreLibraryDesugaringDependency)
}

internal fun Project.configureAndroidSigningConfigForRelease(): Unit =
    configureAndroidApplicationExtension {
        val localStoreFile = consensus.localProperties.getOrNull<File>("store.file")
        if (localStoreFile?.exists() != true) return@configureAndroidApplicationExtension
        defaultConfig {
            signingConfigs {
                create("release") {
                    storeFile = localStoreFile
                    storePassword = consensus.localProperties["store.password"]
                    keyAlias = consensus.localProperties["key.alias"]
                    keyPassword = consensus.localProperties["key.password"]
                }
            }
        }
        buildTypes {
            release {
                signingConfig = signingConfigs["release"]
            }
        }
    }

@Suppress("MagicNumber")
private val MinimalSupportedAndroidPluginVersion = AndroidPluginVersion(8, 0)

private fun checkMinimalSupportedAndroidGradlePluginVersion(): Unit =
    require(AndroidPluginVersion.getCurrent() >= MinimalSupportedAndroidPluginVersion) {
        "Minimal supported Android Gradle Plugin version is 8.0.0"
    }
