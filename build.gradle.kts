buildscript {
    val kotlin_version = "1.6.10"
    val compose_ui_version = "1.1.1"
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.


tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}