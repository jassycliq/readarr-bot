import de.jensklingenberg.ktorfit.gradle.KtorfitGradleConfiguration

plugins {
    kotlin("jvm") version "1.8.20-RC"
    kotlin("plugin.serialization") version "1.8.20-RC"
    application
    id("com.google.devtools.ksp") version "1.8.20-RC-1.0.9"
    id("de.jensklingenberg.ktorfit") version "1.0.0"
}

group = "com.jassycliq"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.kord:kord-core:0.8.0-M17")
    implementation("io.insert-koin:koin-core:3.3.3")
    implementation("io.insert-koin:koin-annotations:1.1.1")
    ksp("io.insert-koin:koin-ksp-compiler:1.1.1")
    implementation("io.github.aakira:napier:2.6.1")
    implementation("org.slf4j:slf4j-simple:2.0.5")

    implementation("io.ktor:ktor-client-core:2.2.4")
    implementation("io.ktor:ktor-client-cio:2.2.4")
    implementation("io.ktor:ktor-client-logging:2.2.4")

    implementation("io.ktor:ktor-client-content-negotiation:2.2.4")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.2.4")
    implementation("dev.forst", "ktor-api-key", "2.2.2")
    implementation("de.jensklingenberg.ktorfit:ktorfit-lib:1.0.0")
    ksp("de.jensklingenberg.ktorfit:ktorfit-ksp:1.0.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

configure<KtorfitGradleConfiguration> {
    version = "1.0.0"
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
}
