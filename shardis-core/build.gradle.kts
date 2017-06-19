import org.gradle.api.tasks.bundling.Jar

tasks.withType<Jar> {
  baseName = "shardis-core"

  doFirst {
    file("${project.buildDir}/classes/java/main/META-INF/spring-configuration-metadata.json").apply {
      if(exists()){
        println("moving spring-configuration-metadata.json to correct location")
        copyTo(file("${project.projectDir}/src/main/resources/META-INF/spring-configuration-metadata.json"),overwrite = true)
        delete()
      }
    }
  }

}
