/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import kotlin.experimental.ExperimentalObjCName

@Suppress("FunctionName")
@OptIn(ExperimentalObjCName::class)
@ObjCName("MainViewController")
fun MainViewController(): UIViewController =
    ComposeUIViewController {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
            content = { Text("Hello, iOS!") },
        )
    }
