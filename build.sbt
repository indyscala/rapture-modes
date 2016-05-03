scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.propensive" %% "rapture-json-circe" % "2.0.0-M3",
  "org.scalaz" %% "scalaz-core" % "7.2.1"
)

initialCommands in console :=
  "import rapture.json._, jsonBackends.circe._\n" +
  "import scalaz._, cats.data._\n" +
  "import indyscala.modes._"
