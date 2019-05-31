package filters

import javax.inject._
import play.api.http.DefaultHttpFilters
import play.api.mvc.{EssentialAction, EssentialFilter}
import play.filters.cors.CORSFilter

@Singleton
class CorsFilter @Inject()(corsFilter: CORSFilter) extends DefaultHttpFilters(corsFilter)