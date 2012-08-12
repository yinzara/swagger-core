import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

  val appName = "petstore"
  val appVersion = "1.1"

  val appDependencies: Seq[sbt.ModuleID] = Seq(
    "com.wordnik" %% "swagger-play2-utils" % "1.1.0-SNAPSHOT")

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
    resolvers := Seq(
      "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository",
      Resolver.url("swagger-core-github-repo", url("http://wordnik.github.com/repository"))(Resolver.ivyStylePatterns),
      "java-net" at "http://download.java.net/maven/2",
      "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"))
}
