/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.gradle.project

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.AppExtension
import me.omico.consensus.api.dsl.consensus
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getOrNull
import java.io.File

internal typealias AndroidCommonExtension = CommonExtension<*, *, *, *, *, *>

internal fun Project.configureCommonAndroid(block: AndroidCommonExtension.() -> Unit): Unit =
    extensions.configure("android", block)

internal fun Project.configureAndroidApplication(block: AppExtension.() -> Unit): Unit =
    extensions.configure("android", block)

internal fun Project.configureCommonAndroid(
    domain: String,
    compileSdk: Int,
    minSdk: Int,
    namespace: String = "$domain.${name.replace("-", ".")}",
    javaVersion: JavaVersion = JavaVersion.toVersion(PROJECT_JAVA_VERSION),
    coreLibraryDesugaringVersion: String = "2.0.4",
) {
    configureCommonAndroid {
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
    dependencies.add("coreLibraryDesugaring", "com.android.tools:desugar_jdk_libs:$coreLibraryDesugaringVersion")
}

internal fun Project.configureAndroidSigningConfigForRelease(): Unit =
    configureAndroidApplication {
        val localStoreFile = consensus.localProperties.getOrNull<File>("store.file")
        if (localStoreFile?.exists() != true) return@configureAndroidApplication
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
            named("release") {
                signingConfig = signingConfigs.findByName("release") ?: signingConfigs["debug"]
                isShrinkResources = true
                isMinifyEnabled = true
                proguardFiles("proguard-rules.pro")
            }
        }
    }
