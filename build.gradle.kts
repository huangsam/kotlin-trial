plugins {
    kotlin("jvm") version "2.1.21"

    // https://github.com/ben-manes/gradle-versions-plugin
    alias(libs.plugins.gradle.versions)

    // https://docs.gradle.org/current/userguide/application_plugin.html
    application

    // https://docs.gradle.org/current/userguide/jacoco_plugin.html
    jacoco
}

group = "com.huangsam"
version = "1.0-SNAPSHOT"

repositories {
    // https://mvnrepository.com/repos/central
    mavenCentral()
}

dependencies {
    // https://www.slf4j.org/manual.html
    implementation(libs.slf4j.api)
    implementation(libs.logback.classic)

    // https://github.com/Kotlin/kotlinx.coroutines
    implementation(libs.bundles.kotlin.coro.all)

    // https://github.com/google/gson/tree/main
    implementation(libs.gson)

    // https://www.baeldung.com/mockito-junit-5-extension
    // https://github.com/mockito/mockito-kotlin
    testImplementation(libs.bundles.mockito.all)

    testImplementation(libs.junit.jupiter)

    // Referenced here until Gradle 9.x is official
    // https://docs.gradle.org/8.3/userguide/upgrading_version_8.html
    testRuntimeOnly(libs.junit.launcher)
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass = "com.huangsam.Application"
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    reports {
        html.required = true
        xml.required = true
    }
}
