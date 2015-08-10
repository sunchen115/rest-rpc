logLevel := Level.Warn

addSbtPlugin("com.qifun" % "sbt-haxe" % "1.3.0")


lazy val sbt_rest_rpc = project in file("sbt-rest-rpc")

lazy val rootProject = (project in file(".")).dependsOn(sbt_rest_rpc)

resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"

addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "0.8.1")
//make-site  //previewSite //package-site


//addSbtPlugin("com.typesafe.sbt" % "sbt-ghpages" % "0.5.4")

