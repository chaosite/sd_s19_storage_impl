import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
}

group = "il.ac.technion.cs.softwaredesign"
version = "1.2"

repositories {
    mavenCentral()
}
allprojects {
    repositories {
        jcenter()
    }

    extra.apply {
        set("junitVersion", "5.5.0-M1")
        set("hamkrestVersion", "1.7.0.0")
        set("guiceVersion", "4.2.2")
        set("kotlinGuiceVersion", "1.3.0")

        set("junitVersion", "5.4.2")
    }
}
val kotlinGuiceVersion: String? by extra
dependencies {
    val junitVersion: String? by extra
    val hamkrestVersion: String? by extra
    val guiceVersion: String? by extra
    val kotlinGuiceVersion : String? by extra
    implementation(kotlin("stdlib-jdk8"))
    compile(kotlin("script-runtime"))
    compile("com.authzee.kotlinguice4", "kotlin-guice", kotlinGuiceVersion)
    testRuntime("org.junit.jupiter", "junit-jupiter-engine", junitVersion)
    
    testCompile("org.junit.jupiter", "junit-jupiter-api", junitVersion)
    testCompile("org.junit.jupiter", "junit-jupiter-params", junitVersion)
    testCompile("com.natpryce", "hamkrest", hamkrestVersion)
    testCompile("com.google.inject", "guice", guiceVersion)
    testCompile("com.authzee.kotlinguice4", "kotlin-guice", kotlinGuiceVersion)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
tasks.withType<Test> {
    useJUnitPlatform()

   
}
tasks.named<Jar>("jar") {
	 println("jar.destinationDir = " + destinationDir)
	 println("archive name:"+archiveName)
 }