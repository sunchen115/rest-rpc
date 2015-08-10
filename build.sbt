

val haxe = "com.qifun.sbt-haxe" %% "test-interface" % "0.1.1" % Test
val specs2 = "org.specs2" %% "specs2" % "2.4.17" % "test"

lazy val commonSettings = Seq(
  organization := "com.example",
  version := "0.1.0",
  scalaVersion := "2.11.4"
)

lazy val helloPlugin = file("/Users/csun/sunchen/study/scala/rpc/sunchen/sbt-rest-rpc/target/scala-2.11/sbt-0.13/sbt-rest-rpc")

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(libraryDependencies += haxe).
  aggregate(core, play, sample)

lazy val core = (project in file("rest-rpc-core"))


lazy val sample = (project in file("rest-rpc-sample")).dependsOn(play)

lazy val play = (project in file("rest-rpc-play")).dependsOn(core)

site.settings

site.includeScaladoc("apis")

site.publishSite

//site.siteMappings <++= Seq(file1 -> "src/main/scala/HellpRpc.scala")
//ghpages.settings
for (c <- Seq(Compile, Test)) yield {
  haxeOptions in c ++= Seq("-dce", "no")
}



