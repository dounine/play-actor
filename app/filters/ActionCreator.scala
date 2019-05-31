package filters

import java.lang.reflect.Method
import java.util.concurrent.CompletionStage

import play.mvc.{Action, Http, Result}

class ActionCreator extends play.http.ActionCreator{
  override def createAction(request: Http.Request, actionMethod: Method): Action[_] = {
    new Action.Simple {
      override def call(req: Http.Request): CompletionStage[Result] = {
        delegate.call(req)
      }
    }
  }
}
