package filters

import java.util.{Collections, Optional}

import akka.stream.scaladsl.FileIO
import javax.inject._
import play.api.http.HttpEntity
import play.api.mvc._

import scala.concurrent.ExecutionContext


@Singleton
class ExampleFilter @Inject()(implicit ec: ExecutionContext) extends EssentialFilter {

  override def apply(next: EssentialAction) = EssentialAction { request =>
    next(request).map { result =>
      result.withHeaders("Access-Control-Allow-Origin" -> "*")
      result.withHeaders("Access-Control-Allow-Credentials" -> "true")
    }
  }
}