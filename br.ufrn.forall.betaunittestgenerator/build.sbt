import AssemblyKeys._

assemblySettings

organization := "br.ufrn.forall.betaunittestgenerator"

name := "BETA Unit Test Generator"

version := "1.0-SNAPSHOT"

scalaVersion := "2.9.2"

scalacOptions := Seq("-deprecation", "-encoding", "utf8")

libraryDependencies ++= Seq( 
	"junit" % "junit" % "4.11",
	"xom" % "xom" % "1.2.5"
	exclude ("xml-apis", "xml-apis")
)

seq(Twirl.settings: _*)

jarName in assembly := "unittestgenerator.jar"
