plugins {
    id("java")
    kotlin("jvm")
    application
    distribution
    checkstyle
}

application {
    mainClass = "hexlet.code.App"
}
group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}
tasks.withType<JavaCompile> {
    options.release = 20
}