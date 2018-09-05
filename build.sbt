name := "scala-playground"

version := "0.2-SNAPSHOT"

scalaVersion := "2.12.6"

scalacOptions += "-language:higherKinds"

resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.3",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)
