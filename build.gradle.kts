import com.moowork.gradle.node.NodeExtension
import com.moowork.gradle.node.npm.NpmTask
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.gradle.api.tasks.bundling.Jar
import org.gradle.api.tasks.testing.Test
import org.gradle.language.jvm.tasks.ProcessResources
import org.gradle.plugins.ide.idea.model.IdeaModel
import org.gradle.testing.jacoco.tasks.JacocoReport
import org.jetbrains.kotlin.allopen.gradle.AllOpenExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.noarg.gradle.NoArgExtension

group = "com.shardis"
version = "0.0.8-SNAPSHOT"

buildscript {

  val kotlinVersion = "1.1.1"
  val springBootVersion = "1.5.2.RELEASE"
  val gradleNodePluginVersion = "1.1.1"
  val dependencyManagementVersion = "1.0.1.RELEASE"

  extra["kotlinVersion"] = kotlinVersion
  extra["springBootVersion"] = springBootVersion

  repositories {
    mavenCentral()
    maven { setUrl("https://plugins.gradle.org/m2/") }
  }

  dependencies {
    classpath("io.spring.gradle:dependency-management-plugin:$dependencyManagementVersion")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    classpath("com.moowork.gradle:gradle-node-plugin:$gradleNodePluginVersion")
    classpath("org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")
    classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
  }
}

apply {
  plugin("io.spring.dependency-management")
  plugin("java")
  plugin("kotlin")
  plugin("kotlin-kapt")
  plugin("kotlin-allopen")
  plugin("kotlin-spring")
  plugin("kotlin-noarg")
  plugin("kotlin-jpa")
  plugin("org.springframework.boot")
  plugin("com.moowork.node")
  plugin("jacoco")
  plugin("idea")
  plugin("eclipse")
}

repositories {
  mavenCentral()
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    jvmTarget = "1.8"
    apiVersion = "1.1"
    languageVersion = "1.1"
  }
}

tasks.withType<Jar> {
  baseName = "shardis"
}

configure<JavaPluginConvention> {
  setSourceCompatibility(1.8)
  setTargetCompatibility(1.8)
  sourceSets.getByName("main").java.srcDirs("${project.buildDir}/generated/source/kapt/")
}

configure<IdeaModel>{
  module.apply {
    sourceDirs.add(file("$buildDir/generated/"))
  }
}

configure<NoArgExtension> {
  annotation("org.axonframework.spring.stereotype.Aggregate")
}


configure<AllOpenExtension> {
  annotation("org.axonframework.spring.stereotype.Aggregate")
}

configure<NodeExtension> {
  version = "7.7.4"
  npmVersion = "4.4.1"
  download = true
  workDir = file("${project.buildDir}/nodejs")
  npmWorkDir = file("${project.buildDir}/npm")
  nodeModulesDir = file("${project.projectDir}")
}


tasks.withType<JacocoReport> {
  reports.apply {
    html.isEnabled = true
    html.setDestination(file("${project.buildDir}/jacocoHtml"))
    xml.isEnabled = true
  }
}

tasks.withType<ProcessResources> {
  filesMatching("**/application.yml") {
    expand(project.properties)
  }
  filesMatching("**/bootstrap.yml") {
    expand(project.properties)
  }
}

tasks.withType<Test> {
  testLogging.apply {
    events("passed", "skipped", "failed", "standardOut", "standardError")
  }
}

val kotlinVersion = extra["kotlinVersion"]
val springBootVersion = extra["springBootVersion"]
val jacksonVersion = the<DependencyManagementExtension>().importedProperties["jackson.version"]
val querydslVersion = the<DependencyManagementExtension>().importedProperties["querydsl.version"]
val axonVersion = "3.0.2"
val jjwtVersion = "0.7.0"
val reflectionsVersion = "0.9.11"

configure<DependencyManagementExtension> {
  imports {
    it.mavenBom("org.springframework.boot:spring-boot-dependencies:$springBootVersion")
  }
}

dependencies {

  configurations.compile.exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")

  compile("org.jetbrains.kotlin:kotlin-stdlib-jre8:$kotlinVersion")
  compile("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

  compile("org.springframework.boot:spring-boot-devtools")
  compile("org.springframework.boot:spring-boot-starter-actuator")
  compile("org.springframework.boot:spring-boot-starter-cache")
  compile("org.springframework.boot:spring-boot-starter-data-jpa")
  compile("org.springframework.boot:spring-boot-starter-security")
  compile("org.springframework.boot:spring-boot-starter-undertow")
  compile("org.springframework.boot:spring-boot-starter-validation")
  compile("org.springframework.boot:spring-boot-starter-web")
  compile("org.springframework.boot:spring-boot-configuration-processor")

  compile("org.axonframework:axon-spring-boot-starter:$axonVersion")

  compile("org.hibernate:hibernate-java8")
  compile("org.hibernate:hibernate-envers")

  compile("com.querydsl:querydsl-jpa:$querydslVersion")

  kapt("com.querydsl:querydsl-apt:$querydslVersion:jpa")
  kapt("org.springframework.boot:spring-boot-configuration-processor")
  kapt("org.hibernate:hibernate-jpamodelgen")

  compile("io.jsonwebtoken:jjwt:$jjwtVersion")

  compile("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
  compile("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
  compile("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")

  runtime("com.h2database:h2")
  runtime("org.postgresql:postgresql")

  testCompile("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
  testCompile("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
  testCompile("org.springframework.boot:spring-boot-starter-test")
  testCompile("org.springframework.security:spring-security-test")
  testCompile("org.reflections:reflections:$reflectionsVersion")
  testCompile("org.axonframework:axon-test:$axonVersion")
}

task<NpmTask>("ngBuild") {
  dependsOn("npm_install")

  inputs.file("package.json")
  inputs.file(".angular-cli.json")
  inputs.files(fileTree("src/main/typescript"))

  outputs.dir("src/main/resources/static")

  args = listOf("run", "build:prod")
}

task<NpmTask>("ngTest") {
  dependsOn("npm_install")
  args = listOf("run", "test")
}

tasks.getByName("processResources").dependsOn("ngBuild")
tasks.getByName("test").dependsOn("ngTest")
tasks.getByName("check").finalizedBy("jacocoTestReport")
tasks.getByName("clean").doLast {
  delete("node_modules")
}

