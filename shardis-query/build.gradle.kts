import org.gradle.api.tasks.bundling.Jar

dependencies {
  compile(project(":shardis-common"))
}

tasks.withType<Jar> {
  baseName = "shardis-query"
}
