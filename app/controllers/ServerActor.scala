package controllers

import akka.actor.{Actor, ActorLogging}


class ServerActor extends Actor with ActorLogging {
  override def receive: Receive = {
    case Message.PING(msg: String) =>
      println(s"收到客户端发来的消息：$msg")
      sender() ! Message.PONG("我是服务端")
  }
}
