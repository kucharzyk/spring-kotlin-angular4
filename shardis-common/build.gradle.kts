import org.gradle.api.tasks.bundling.Jar

tasks.withType<Jar> {
  baseName = "shardis-common"
}
