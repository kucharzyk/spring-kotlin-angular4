import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.testing.jacoco.tasks.JacocoReport
import org.jetbrains.kotlin.allopen.gradle.AllOpenExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.noarg.gradle.NoArgExtension

allprojects {

  group = "com.shardis"
  version = "0.1.3-SNAPSHOT"

  repositories {
    mavenCentral()
  }

}

buildscript {

  val kotlinVersion = "1.1.2"
  val springBootVersion = "1.5.4.RELEASE"
  val gradleNodePluginVersion = "1.2.0"
  val dependencyManagementVersion = "1.0.3.RELEASE"

  project.extra.set("kotlinVersion", kotlinVersion)
  project.extra.set("springBootVersion", springBootVersion)

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

subprojects {

  apply {
    plugin("io.spring.dependency-management")
    plugin("java")
    plugin("kotlin")
    plugin("kotlin-kapt")
    plugin("kotlin-allopen")
    plugin("kotlin-spring")
    plugin("kotlin-noarg")
    plugin("kotlin-jpa")
    plugin("jacoco")
    plugin("idea")
    plugin("eclipse")
  }


  tasks.withType<KotlinCompile> {
    kotlinOptions {
      jvmTarget = "1.8"
      apiVersion = "1.1"
      languageVersion = "1.1"
      suppressWarnings = true
    }
  }

  configure<JavaPluginConvention> {
    setSourceCompatibility(1.8)
    setTargetCompatibility(1.8)
    sourceSets.getByName("main").java.srcDirs("${project.buildDir}/generated/source/kapt/")
  }

  configure<NoArgExtension> {
    annotation("org.axonframework.spring.stereotype.Aggregate")
  }


  configure<AllOpenExtension> {
    annotation("org.axonframework.spring.stereotype.Aggregate")
  }


  tasks.withType<JacocoReport> {
    reports.apply {
      html.isEnabled = true
      html.destination = file("${project.buildDir}/jacocoHtml")
      xml.isEnabled = true
    }
  }


  tasks.withType<Test> {
    testLogging.apply {
      events("passed", "skipped", "failed", "standardOut", "standardError")
    }
  }


  configure<DependencyManagementExtension> {
    imports {
      val springBootVersion = parent.extra.get("springBootVersion")
      mavenBom("org.springframework.boot:spring-boot-dependencies:$springBootVersion")
    }
  }

  dependencies {

    val kotlinVersion = parent.extra.get("kotlinVersion")
    val jacksonVersion = the<DependencyManagementExtension>().importedProperties["jackson.version"]
    val querydslVersion = the<DependencyManagementExtension>().importedProperties["querydsl.version"]
    val axonVersion = "3.0.5"
    val jjwtVersion = "0.7.0"
    val reflectionsVersion = "0.9.11"


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

  tasks.getByName("check").finalizedBy("jacocoTestReport")

}

