import com.moowork.gradle.node.NodeExtension
import com.moowork.gradle.node.yarn.YarnTask
import org.gradle.api.tasks.bundling.Jar

apply {
  plugin("com.moowork.node")
}

tasks.withType<Jar> {
  baseName = "shardis-frontend"
}

configure<NodeExtension> {
  version = "7.10.0"
  yarnVersion = "0.24.5"
  download = true
  workDir = file("${project.buildDir}/nodejs")
  yarnWorkDir = file("${project.buildDir}/yarn")
  nodeModulesDir = file("${project.projectDir}")
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
