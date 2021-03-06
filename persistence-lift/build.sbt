import sbt._
import sbt.Keys._
import io.escalante.sbt.EscalantePlugin._
import io.escalante.sbt.EscalantePlugin.EscalanteKeys._
escalanteSettings

version := "0.3.0"

scalaVersion := "2.9.1"

liftWarName in liftWar := "escalante-persistence-lift.war"

liftVersion in liftWar := Some("2.4")

libraryDependencies <++= (liftVersion in liftWar) { lv: Option[String] => Seq(
    "net.liftweb" %% "lift-webkit" % lv.get % "provided",
    "net.liftweb" %% "lift-mapper" % lv.get % "provided"
  )
}
