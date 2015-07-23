name := "scala-playground"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.7"

scalacOptions += "-language:higherKinds"

resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.2.3",
  "org.scalatest" %% "scalatest" % "2.2.5" % "test"
)
