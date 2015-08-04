

val haxe =  "com.qifun.sbt-haxe" %% "test-interface" % "0.1.1" % Test
val specs2 = "org.specs2" %% "specs2" % "2.4.17" % "test"

lazy val commonSettings = Seq(
  organization := "com.example",
  version := "0.1.0",
  scalaVersion := "2.11.4"
)

lazy val root = (project in file(".")).settings(commonSettings: _*).aggregate(core, play, sample)

lazy val core = (project in file("rest-rpc-core")).settings(commonSettings: _*)


lazy val play = (project in file("rest-rpc-play")).settings(commonSettings: _*).dependsOn(core)

lazy val sample = (project in file("rest-rpc-sample")).
  settings(commonSettings: _*).
  settings(libraryDependencies += specs2 ).
  dependsOn(play)

