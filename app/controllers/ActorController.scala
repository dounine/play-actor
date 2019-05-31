package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc._
import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

@Singleton
class ActorController @Inject()(cc: ControllerComponents, actorSystem: ActorSystem)(implicit ec: ExecutionContext)
  extends AbstractController(cc) {

  val testActor: ActorRef = actorSystem.actorOf(Props[ServerActor], "hello")
  implicit val timeout: Timeout = 3.seconds

  def PING(): Action[AnyContent] = Action.async {
    (testActor ? Message.PING).mapTo[String].map(message => Ok(message))
  }

  def send(): Action[AnyContent] = Action {
    actorSystem.actorOf(Props(new ClientActor()))
    Ok("success")
  }


  def init: Action[AnyContent] = Action {
    Ok("init success")
  }

}