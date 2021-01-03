name := "prefecture-city-startUp.batch"

version := "0.1"

scalaVersion := "2.13.4"

val doobieVersion = "0.9.0"
val sttpVersion   = "3.0.0-RC13"
val circeVersion  = "0.13.0"
val monixVersion  = "3.3.0"

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client3" %% "core"                            % sttpVersion,
  "com.softwaremill.sttp.client3" %% "async-http-client-backend-monix" % sttpVersion,
  "com.softwaremill.sttp.client3" %% "circe"                           % sttpVersion,
  "io.circe"                      %% "circe-parser"                    % circeVersion,
  "io.circe"                      %% "circe-core"                      % circeVersion,
  "io.circe"                      %% "circe-generic"                   % circeVersion,
  "org.tpolecat"                  %% "doobie-core"                     % doobieVersion,
  "org.tpolecat"                  %% "doobie-hikari"                   % doobieVersion,
//  "io.monix"                      %% "monix"                           % monixVersion,
  "io.monix"                 %% "monix-eval"          % monixVersion,
  "com.softwaremill.macwire" %% "macros"              % "2.3.6" % Provided,
  "ch.qos.logback"           % "logback-classic"      % "1.2.3",
  "com.typesafe"             % "config"               % "1.4.1",
  "mysql"                    % "mysql-connector-java" % "8.0.11",
  "com.softwaremill.sttp"    %% "circe"               % "1.7.2"
)
