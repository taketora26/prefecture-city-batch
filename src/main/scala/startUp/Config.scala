package startUp

import com.typesafe.config.ConfigFactory

object Config {

  private val conf = ConfigFactory.load()

  case class Doobie(driver: String, jdbcUrl: String, user: String, password: String)

  lazy val doobie = Doobie(
    conf.getString("db.default.driver"),
    conf.getString("db.default.url"),
    conf.getString("db.default.user"),
    conf.getString("db.default.password")
  )

  case class ResasApi(xApiKey: String, url: String)

  lazy val resasApi = ResasApi(
    conf.getString("api.resas.xApiKey"),
    conf.getString("api.resas.url")
  )

}
