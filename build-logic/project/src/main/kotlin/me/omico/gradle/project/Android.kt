/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.gradle.project

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

internal typealias AndroidCommonExtension = CommonExtension<*, *, *, *, *>

internal fun Project.configureCommonAndroid(block: AndroidCommonExtension.() -> Unit): Unit =
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

internal fun Project.configureCommonAndroidCompose() {
    configureCommonAndroid {
        buildFeatures {
            compose = true
        }
    }
    configureComposeCompiler()
}
