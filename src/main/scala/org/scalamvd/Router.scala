package org.scalamvd

import akka.actor.Actor
import spray.routing._

// we don't implement our route structure directly in the router actor because
// we want to be able to test it independently, without having to spin up an actor
class Router extends Actor
  with Ping {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  lazy val route = test

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(route)

}


trait Ping extends HttpService {
  val test =
    path("test"){
      get {
        complete("Testing 1 2 3 ... ")
      }
    }
}

