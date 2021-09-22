import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.30"
    application
    id("kotlinx-kover") version "0.2.2"
}

group = "kotlinx"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

tasks.test {
    extensions.configure(kotlinx.kover.KoverTaskExtension::class) {
        useJacoco = false
        includes += "kotlinx\\.testapp\\..*"
    }
}


kover {
    jacocoAgentVersion.set("0.8.7")
}
