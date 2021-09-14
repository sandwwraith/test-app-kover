import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.30"
    application
    jacoco
    id("kotlinx-kover") version "0.1.0"
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
//        useJacoco = false // false by default
//        xmlReportFile.set(file("$buildDir/custom/report.xml"))
        includes += "kotlinx\\.testapp\\..*"
    }
}


kover {
    intellijAgentVersion.set("1.0.597")

    jacocoAgentVersion.set("0.8.7")
}

jacoco {
//    toolVersion = "0.8.7"
}

// Configurable per-task
//tasks.test {
//    extensions.configure(kotlinx.kover.KoverTaskExtension::class) {
//        useJacoco = true
////        xmlReportFile.set(file("$buildDir/custom/report.xml"))
//        includes += "kotlinx\\.testapp\\..*"
//    }
//}
