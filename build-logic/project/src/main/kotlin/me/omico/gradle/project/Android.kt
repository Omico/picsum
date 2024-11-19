/*
 * Copyright 2024-2025 Omico. All Rights Reserved.
 */
package me.omico.gradle.project

import me.omico.consensus.api.dsl.consensus
import me.omico.kami.android.dsl.configureAndroidApplicationExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getOrNull
import java.io.File

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
