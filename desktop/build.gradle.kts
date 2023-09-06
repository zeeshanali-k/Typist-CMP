plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}


group = "com.devscion.typist-cmp"
version = "1.0.0"

kotlin {
    jvm {
        withJava()
        compilations.all {
            kotlinOptions.jvmTarget = "17"
        }
    }
// 2
    sourceSets {
        val jvmMain by getting {
            // 3
            kotlin.srcDirs("src/jvmMain/kotlin")
            dependencies {
                // 4
                implementation(compose.desktop.currentOs)
                implementation(project(":sample"))
            }
        }
    }

}