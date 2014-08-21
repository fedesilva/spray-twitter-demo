package org.scalamvd

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http

/** Main entry point of the Application.
  *
  * Must have a main method or extend App
  *
  */

object  TwitterAnalysisService {

  // Unit es el tipo vacío. Void o variaciones en Java, C/C++ o C# por ejemplo.
  def main(args: Array[String]): Unit = {

    // we need an ActorSystem to host our application in.
    // marking it as implicit make it available to functions that declare an
    // implicit dependency. It's kind of injected.
    implicit val system = ActorSystem("on-spray-can")

    // create and start our service actor
    val service = system.actorOf(Props(classOf[Router]), "demo-service")

    // start a new HTTP server on port 8080 with our service actor as the handler
    IO(Http) ! Http.Bind(service, interface = "localhost", port = 8080)

  }

}
