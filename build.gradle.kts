plugins {
    kotlin("jvm") version "2.4.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // Para SQLite
    //implementation("org.xerial:sqlite-jdbc:3.43.0.0")
    implementation("org.postgresql:postgresql:42.7.1")
}

kotlin {
    jvmToolchain(24)
}

tasks.test {
    useJUnitPlatform()
}


tasks.withType<JavaExec> {
    jvmArgs("--enable-native-access=ALL-UNNAMED")
}