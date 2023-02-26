plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "me.michigang1"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
application {
    mainClass.set("cli.app.AppKt")
}
dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
    sourceSets {
        main {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")
            }
        }
    }
}

java {
    withSourcesJar()
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes(
            "Main-Class" to "cli.app.AppKt",
        )
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
