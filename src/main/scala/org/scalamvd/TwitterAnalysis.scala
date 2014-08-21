package org.scalamvd

import spray.routing.HttpServiceActor

/**
 * Twitter related routes
 */

trait TwitterAnalysis extends HttpServiceActor {

  val Path = "search"

  val searchGet =
    path(Path) {
      get{
        complete("NOT_IMPLEMENTED")
      }
    }

  val searchFail =
    path(Path) {
      reject
    }


}
