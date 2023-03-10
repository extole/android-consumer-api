lazy val root = (project in file(".")).
  settings(
    organization := "com.extole.consumer",
    name := "consumer-api-feign",
    version := "1.0.25",
    scalaVersion := "2.11.4",
    scalacOptions ++= Seq("-feature"),
    javacOptions in compile ++= Seq("-Xlint:deprecation"),
    publishArtifact in (Compile, packageDoc) := false,
    resolvers += Resolver.mavenLocal,
    libraryDependencies ++= Seq(
      "io.swagger.core.v3" % "swagger-annotations" % "2.0.0" % "compile",
      "com.netflix.feign" % "feign-core" % "9.4.0" % "compile",
      "com.netflix.feign" % "feign-jackson" % "9.4.0" % "compile",
      "com.netflix.feign" % "feign-slf4j" % "9.4.0" % "compile",
      "io.github.openfeign.form" % "feign-form" % "2.1.0" % "compile",
      "com.fasterxml.jackson.core" % "jackson-core" % "2.10.1" % "compile",
      "com.fasterxml.jackson.core" % "jackson-annotations" % "2.10.1" % "compile",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.10.1" % "compile",
      "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.10.1" % "compile",
      "com.brsanthu" % "migbase64" % "2.2" % "compile",
      "junit" % "junit" % "4.12" % "test",
      "com.novocode" % "junit-interface" % "0.10" % "test"
    )
  )
