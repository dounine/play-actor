name := """play-actor"""

version := "1.0-SNAPSHOT"

maintainer := "amwoqmgo@gmail.com"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.12.8"
val akkaHTTPVersion = "10.1.8"

libraryDependencies ++= Seq(
  guice,
  ws,
  filters,
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test,
  "com.typesafe.akka" %% "akka-actor" % "2.5.21",
  "com.typesafe.akka" %% "akka-slf4j" % "2.5.21",
  "com.typesafe.akka" %% "akka-remote" % "2.5.21",
  "com.typesafe.akka" %% "akka-stream" % "2.5.21",
  "com.typesafe.akka" %% "akka-protobuf" % "2.5.21"
)

scalacOptions ++= Seq(
  "-language:implicitConversions",
  "-feature",
  "-deprecation",
  "-Xfatal-warnings"
)
