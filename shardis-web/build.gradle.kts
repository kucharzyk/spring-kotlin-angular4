import org.gradle.api.tasks.bundling.Jar
import org.gradle.language.jvm.tasks.ProcessResources

apply {
  plugin("org.springframework.boot")
}

dependencies {
  compile(project(":shardis-common"))
  compile(project(":shardis-angular"))
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

