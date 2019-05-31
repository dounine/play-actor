package controllers

import akka.actor.{Actor, ActorLogging}


class ClientActor extends Actor with ActorLogging {

  override def preStart(): Unit = {
    val actor = context.actorSelection(s"akka.tcp://ServerSystem@localhost:2000/user/ServerActor")
    actor ! Message.PING("我是客户端")
  }

  override def receive: Receive = {
    case Message.PONG(msg: String) =>
      println(s"收到服务端发来的消息：$msg")
  }
}
