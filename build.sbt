import AssemblyKeys._ // put this at the top of the file
import de.johoop.jacoco4sbt._
import JacocoPlugin._

name:="cross-cutting-concern"

version:="1.0"

scalaVersion:="2.10.3"

fork := true

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

javaOptions           ++= Seq("-javaagent:" + System.getProperty("user.home") + "/.ivy2/cache/org.aspectj/aspectjweaver/jars/aspectjweaver-1.6.8.jar")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/",
  "spray nightly repo" at "http://nightlies.spray.io",
   "opencast-public" at "http://repository.opencastproject.org/nexus/content/repositories/public/"
)


// Add multiple dependencies
libraryDependencies ++= Seq(
	"ch.qos.logback" 		% 	"logback-classic" 	% 	"1.0.13",
  	"org.specs2"          		%%  	"specs2"        	% 	"1.14" 		% 	"test",
	"junit" 			% 	"junit" 		% 	"4.11"		%	"test",
	"org.scalatest" 		%% 	"scalatest" 		% 	"1.9.2"		%	"test",
	"org.aspectj" 			% 	"aspectjweaver" 	% 	"1.7.2",
	"org.aspectj" 			% 	"aspectjrt" 		% 	"1.7.2"
)


test in assembly := {}

org.scalastyle.sbt.ScalastylePlugin.Settings

seq(Revolver.settings: _*)

seq(jacoco.settings : _*)

seq(ScctPlugin.instrumentSettings : _*)



