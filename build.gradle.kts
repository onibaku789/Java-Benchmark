plugins {
    id("java")
    id ("me.champeau.jmh") version "0.6.6"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")


}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}


jmh {
    warmupIterations.set(0)
    iterations.set(2)
    fork.set(2)
}