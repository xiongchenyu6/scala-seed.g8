import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(
    name := "$name$",
    Defaults.itSettings,
    libraryDependencies ++= Seq(
      scalaTest  % "it,test"
    )
  )
// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-encoding",
  "UTF-8",
  "-Xcheckinit", // for debugging only, see https://github.com/paulp/scala-faq/wiki/Initialization-Order
  "-Ypartial-unification",
  "-Xverify",
  "-feature",
  "-target:jvm-1.8",
  "-language:higherKinds",
  "-language:implicitConversions"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

resolvers ++= Seq(
  Resolver.mavenLocal // Search local maven first for dev
)
