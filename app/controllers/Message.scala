package controllers

object Message extends Serializable {

  case class PING(msg: String) extends Serializable

  case class PONG(msg: String) extends Serializable

}
