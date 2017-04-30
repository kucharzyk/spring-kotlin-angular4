import com.moowork.gradle.node.NodeExtension
import com.moowork.gradle.node.yarn.YarnTask
import org.gradle.api.tasks.bundling.Jar
import org.gradle.language.jvm.tasks.ProcessResources

apply {
  plugin("org.springframework.boot")
  plugin("com.moowork.node")
}

dependencies {
  compile(project(":shardis-common"))
}

tasks.withType<Jar> {
  baseName = "shardis"
}

configure<NodeExtension> {
  version = "7.9.0"
  yarnVersion = "0.23.3"
  download = true
  workDir = file("${project.buildDir}/nodejs")
  yarnWorkDir = file("${project.buildDir}/yarn")
  nodeModulesDir = file("${project.projectDir}")
}

tasks.withType<ProcessResources> {
  filesMatching("**/application.yml") {
    expand(project.properties)
  }
  filesMatching("**/bootstrap.yml") {
    expand(project.properties)
  }
}

task<YarnTask>("ngBuild") {
  dependsOn("yarn_install")

  inputs.file("package.json")
  inputs.file(".angular-cli.json")
  inputs.files(fileTree("src/main/typescript"))

  outputs.dir("src/main/resources/static")

  args = listOf("run", "build:prod")
}

task<YarnTask>("ngTest") {
  dependsOn("yarn_install")
  args = listOf("run", "test")
}

tasks.getByName("processResources").dependsOn("ngBuild")
tasks.getByName("test").dependsOn("ngTest")

tasks.getByName("clean").doLast {
  delete("node_modules")
  delete("coverage")
  delete("documentation")
  delete("dist")
}
