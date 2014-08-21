package org.scalamvd

import org.specs2.mutable.Specification
import spray.http.StatusCodes._
import spray.testkit.Specs2RouteTest

class PingSpec extends Specification
  with Specs2RouteTest
  with Ping {

  def actorRefFactory = system

  val path    = "/test"
  val badPath = "/mumbojumboblablah"

  "PingService" should {

    "return a greeting for GET requests to the test path" in {
      Get(path) ~> test ~> check {
        responseAs[String] must contain("Testing")
      }
    }

    "leave GET requests to other paths unhandled" in {
      Get("/kermit") ~> test ~> check {
        handled must beFalse
      }
    }

    "return a MethodNotAllowed error for PUT requests to the root path" in {
      Put(path) ~> sealRoute(test) ~> check {
        status === MethodNotAllowed
        responseAs[String] === "HTTP method not allowed, supported methods: GET"
      }
    }

  }
}
