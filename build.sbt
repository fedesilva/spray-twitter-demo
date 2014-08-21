organization  := "org.scalamvd"

name := "twitter-analysis-service"

version       := "0.1-SNAPSHOT"

scalaVersion  := "2.11.2"

scalacOptions := Seq(
  "-unchecked", 
  "-deprecation", 
  "-encoding", "utf8",
  "-feature"
)

libraryDependencies ++= {
  val akkaV = "2.3.4"
  val sprayV = "1.3.1"
  Seq(
    "io.spray"            %% "spray-can"                      % sprayV,
    "io.spray"            %% "spray-routing-shapeless2"       % sprayV,
    "com.typesafe.akka"   %% "akka-actor"                     % akkaV,
    "io.spray"            %% "spray-json"                     % "1.2.6",
    "io.spray"            %% "spray-testkit"                  % sprayV    % "test",
    "com.typesafe.akka"   %% "akka-testkit"                   % akkaV     % "test",
    "org.specs2"          %% "specs2"                         % "2.3.13"  % "test"
  )
}

resolvers ++= Seq(
  "spray repo"            at "http://repo.spray.io",
  "spray nightlies repo"  at "http://nightlies.spray.io"
)


