import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.72"
}

group = "il.ac.technion.cs.softwaredesign"
version = "1.2.1"

repositories {
    mavenCentral()
}
allprojects {
    repositories {
        jcenter()
    }

    extra.apply {
        set("kotlinGuiceVersion", "1.4.1")
    }
}
val kotlinGuiceVersion: String? by extra
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile(kotlin("script-runtime"))
    implementation("dev.misfitlabs.kotlinguice4", "kotlin-guice", kotlinGuiceVersion)

}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
tasks.named<Jar>("jar") {
	 println("jar.destinationDir = " + destinationDir)
	 println("archive name:"+archiveName)
 }
