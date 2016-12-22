
buildscript {
    val kotlinVersion = "1.0.5-3"
    val springBootVersion = "1.4.2.RELEASE"

    extra["kotlinVersion"] = kotlinVersion
    extra["springBootVersion"] = springBootVersion

    repositories {
        mavenCentral()
        jcenter()
        maven{ setUrl("https://plugins.gradle.org/m2") }
    }

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

apply {
    plugin("idea")
    plugin("kotlin")
    plugin("application")
    plugin("org.springframework.boot")
    plugin("jacoco")
}

version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

configure<JavaPluginConvention> {
    setSourceCompatibility(1.8)
    setTargetCompatibility(1.8)
}

configure<ApplicationPluginConvention> {
    mainClassName = "com.shardis.ShardisApplication"
}

val kotlinVersion = extra["kotlinVersion"] as String
val jacksonVersion = "2.8.4"
val jjwtVersion = "0.7.0"
val reflectionsVersion = "0.9.10"

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    compile("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

    compile("org.springframework.boot:spring-boot-starter-actuator")
    compile("org.springframework.boot:spring-boot-starter-cache")
    compile("org.springframework.boot:spring-boot-devtools")
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-configuration-processor")

    kapt("org.springframework.boot:spring-boot-configuration-processor")

    compile("io.jsonwebtoken:jjwt:${jjwtVersion}")

    compile("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    compile("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")

    runtime("com.h2database:h2")
    runtime("org.postgresql:postgresql")

    testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile("org.reflections:reflections:${reflectionsVersion}")
}
