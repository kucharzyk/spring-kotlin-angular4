import com.bmuschko.gradle.docker.tasks.DockerVersion
import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage
import org.gradle.api.tasks.bundling.Jar
import org.gradle.language.jvm.tasks.ProcessResources


apply {
  plugin("org.springframework.boot")
  plugin("com.bmuschko.docker-remote-api")
}

dependencies {
  compile(project(":shardis-core"))
  compile(project(":shardis-query"))
  compile(project(":shardis-frontend"))
}

tasks.withType<Jar> {
  baseName = "shardis"
}

tasks.withType<ProcessResources> {
  filesMatching("**/application.yml") {
    expand(project.properties)
  }
  filesMatching("**/bootstrap.yml") {
    expand(project.properties)
  }
}

task<DockerVersion>("dockerVersion")

task<DockerBuildImage>("buildImage") {
  dependsOn("dockerVersion")
  inputDir = file("${project.projectDir}/")
  tags = setOf(
    "shardis/shardis-webapp:latest",
    "shardis/shardis-webapp:${project.version}".replace("-SNAPSHOT","_SNAPSHOT")
  )
}

tasks.getByName("build").finalizedBy("buildImage")
