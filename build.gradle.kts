plugins {
    id("java")
    id("me.champeau.jmh") version "0.6.6"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
    implementation("net.datafaker:datafaker:1.4.0")
    jmhAnnotationProcessor("org.openjdk.jmh:jmh-generator-annprocess:1.35")
    jmh("org.openjdk.jmh:jmh-core:1.35")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}