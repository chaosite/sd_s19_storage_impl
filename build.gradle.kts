import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
}

group = "il.ac.technion.cs.softwaredesign"
version = "1.1"

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
        set("kotlinGuiceVersion", "1.4.1")
    }
}
val kotlinGuiceVersion: String? by extra
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile(kotlin("script-runtime"))
    //compile("com.authzee.kotlinguice4", "kotlin-guice", kotlinGuiceVersion)
    implementation("dev.misfitlabs.kotlinguice4", "kotlin-guice", kotlinGuiceVersion)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
tasks.named<Jar>("jar") {
	 println("jar.destinationDir = " + destinationDir)
	 println("archive name:"+archiveName)
 }