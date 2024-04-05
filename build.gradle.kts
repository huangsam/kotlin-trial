import io.gitlab.arturbosch.detekt.Detekt

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.23"

    // https://github.com/detekt/detekt
    id("io.gitlab.arturbosch.detekt") version "1.23.6"

    // https://github.com/ben-manes/gradle-versions-plugin
    id("com.github.ben-manes.versions") version "0.51.0"

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
    implementation("org.slf4j:slf4j-api:2.0.12")
    implementation("ch.qos.logback:logback-classic:1.5.3")

    // https://github.com/Kotlin/kotlinx.coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")

    // https://github.com/google/gson/tree/main
    implementation("com.google.code.gson:gson:2.10.1")

    // https://www.baeldung.com/mockito-junit-5-extension
    testImplementation("org.mockito:mockito-core:5.11.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.11.0")

    // https://github.com/mockito/mockito-kotlin
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.2.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.junit.jupiter:junit-jupiter-params")

    // Referenced here until Gradle 9.x is official
    // https://docs.gradle.org/8.3/userguide/upgrading_version_8.html
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass = "com.huangsam.Application"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}

jacoco {
    toolVersion = "0.8.11"
}

detekt {
    buildUponDefaultConfig = true // preconfigure defaults
    allRules = false // activate all available (even unstable) rules.
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true)
        xml.required.set(true)
        sarif.required.set(true)
    }
}

// Instructions to register and configure a task
// https://docs.gradle.org/current/userguide/more_about_tasks.html
tasks.register<Copy>("addHooks") {
    group = "Setup"
    description = "Adds Git hooks from .hooks to .git/hooks"
    from(".hooks")
    into(".git/hooks")
}
