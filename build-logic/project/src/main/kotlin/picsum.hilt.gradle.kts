import me.omico.gradm.dependency.Hilt
import me.omico.kami.kotlin.dsl.onKotlinAndroidApplied
import me.omico.kami.kotlin.dsl.onKotlinMultiplatformApplied

plugins {
    id("me.omico.kami.kotlin.base")
    id("com.google.dagger.hilt.android")
}

kami {
    kotlin {
        compilerPlugins {
            ksp()
        }
    }
}

onKotlinAndroidApplied {
    dependencies {
        add("implementation", Hilt.android)
        add("ksp", Hilt.android.compiler)
    }
}

onKotlinMultiplatformApplied {
    dependencies {
        add("androidMainImplementation", Hilt.android)
        add("kspAndroid", Hilt.android.compiler)
    }
}
