import com.moowork.gradle.node.NodeExtension
import com.moowork.gradle.node.yarn.YarnTask
import org.gradle.api.tasks.bundling.Jar
import org.gradle.api.tasks.testing.Test
import org.gradle.language.jvm.tasks.ProcessResources
import org.gradle.testing.jacoco.tasks.JacocoReport
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
  val kotlinVersion = "1.1.0-beta-38"
  val springBootVersion = "1.5.1.RELEASE"
  val gradleNodePluginVersion = "1.1.1"

  repositories {
    mavenCentral()
    maven { setUrl("https://plugins.gradle.org/m2/") }
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
  }

  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    classpath("com.moowork.gradle:gradle-node-plugin:$gradleNodePluginVersion")
    classpath("org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")
    classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
  }
}

apply {
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
}

group = "com.shardis"
version = "0.0.4-SNAPSHOT"

repositories {
  mavenCentral()
  maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
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
  sourceSets.getByName("main").resources.srcDirs("$buildDir/generated/source/kapt/")
}


configure<NodeExtension> {
  version = "7.5.0"
  yarnVersion = "0.19.1"
  download = true
  workDir = file("${project.buildDir}/nodejs")
  yarnWorkDir = file("${project.buildDir}/yarn")
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


dependencies {

  val kotlinVersion = "1.1.0-beta-38"
  val jacksonVersion = "2.8.6"
  val jjwtVersion = "0.7.0"
  val reflectionsVersion = "0.9.10"

  configurations.compile.exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")

  compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
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

  compile("org.hibernate:hibernate-java8")
  compile("org.hibernate:hibernate-envers")

  kapt("org.springframework.boot:spring-boot-configuration-processor")
  kapt("org.hibernate:hibernate-jpamodelgen")

  compile("io.jsonwebtoken:jjwt:$jjwtVersion")

  compile("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
  compile("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
  compile("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")

  runtime("com.h2database:h2")
  runtime("org.postgresql:postgresql")

  testCompile("org.springframework.boot:spring-boot-starter-test")
  testCompile("org.springframework.security:spring-security-test")
  testCompile("org.reflections:reflections:$reflectionsVersion")
}

task<YarnTask>("ngBuild") {
  dependsOn("yarn_install")
  args = listOf("run", "build:prod")
}

task<YarnTask>("ngTest") {
  dependsOn("yarn_install")
  args = listOf("run", "test")
}

tasks.getByName("jacocoTestReport").dependsOn("test")
tasks.getByName("yarn_install").dependsOn("yarnSetup")
tasks.getByName("processResources").dependsOn("ngBuild")
tasks.getByName("test").dependsOn("ngTest")
tasks.getByName("check").finalizedBy("jacocoTestReport")
tasks.getByName("clean").doLast {
  delete("node_modules")
}

