plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM
    kotlin("jvm") version "1.3.11"

    // Apply the application to add support for building a CLI application
    application
    java
    idea

}
idea {
    module {
        downloadJavadoc = true
        downloadSources = true
    }
}
repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    compile("com.authzee.kotlinguice4:kotlin-guice:1.2.0")
    compile("com.authzee.kotlinguice4:kotlin-guice-multibindings:1.2.0")

    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.11")
    // Use the Kotlin test library
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    // Define the main class for the application
    mainClassName = "SpecialSync.AppKt"
}
