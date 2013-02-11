name := "MkTree" 

scalaVersion := "2.9.1"

libraryDependencies ++= Seq (
  "org.scalatest" %% "scalatest" % "1.9.1" % "test",
  "com.google.code.java-allocation-instrumenter" % "java-allocation-instrumenter" % "2.0",
  "com.google.code.gson" % "gson" % "1.7.1",
  "com.google.caliper" % "caliper" % "0.5-rc1"
)

resolvers ++= Seq(
    "sonatypeSnapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
    "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

// enable forking in run
fork in run := true

// we need to add the runtime classpath as a "-cp" argument to the `javaOptions in run`, otherwise caliper
// will not see the right classpath and die with a ConfigurationException
javaOptions in run <++= (fullClasspath in Runtime) map { cp => Seq("-cp", sbt.Build.data(cp).mkString(":"), "-Xmx2G") }