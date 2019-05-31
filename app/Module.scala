import com.google.inject.AbstractModule
import java.time.Clock
import play.api.libs.concurrent.AkkaGuiceSupport

import services.{ApplicationTimer}
import controllers._

class Module extends AbstractModule with AkkaGuiceSupport {

  override def configure() = {
    bind(classOf[Clock]).toInstance(Clock.systemDefaultZone)
    bind(classOf[ApplicationTimer]).asEagerSingleton()
    //bindActor[HelloActor]("hello-actor")
  }

}
