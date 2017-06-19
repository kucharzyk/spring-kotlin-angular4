import org.gradle.api.tasks.bundling.Jar

dependencies {
  compile(project(":shardis-core"))
}

tasks.withType<Jar> {
  baseName = "shardis-query"
}
