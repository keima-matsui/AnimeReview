name := """MyApp001"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  evolutions,
  javaJdbc,
  cache,
  javaWs,
  "org.webjars" %% "webjars-play" % "2.4.0",
  "org.webjars" % "bootstrap" % "3.0.1",
  "mysql" % "mysql-connector-java" % "5.1.20",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.7.0",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.0",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.7.0",
  "org.twitter4j" % "twitter4j-core" % "4.0.2"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator


fork in run := true