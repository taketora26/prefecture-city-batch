package startUp.modules

import cats.effect.IO
import domain.{CityRepository, PrefectureRepository, ResasRepository}
import doobie.Transactor
import infrastructure.http.resas.ResasRepositoryImpl
import infrastructure.mysql.{CityRepositoryImpl, PrefectureRepositoryImpl}
import monix.eval.Task
import startUp.Config

import scala.concurrent.ExecutionContext

trait InfrastructureComponent {

  implicit lazy val cs = IO.contextShift(ExecutionContext.global)

  lazy val mxa: Transactor[Task] = Transactor.fromDriverManager[Task](
    Config.doobie.driver,
    Config.doobie.jdbcUrl,
    Config.doobie.user,
    Config.doobie.password
  )

  lazy val cityRepository: CityRepository             = new CityRepositoryImpl(mxa)
  lazy val prefectureRepository: PrefectureRepository = new PrefectureRepositoryImpl(mxa)
  lazy val resasRepository: ResasRepository           = new ResasRepositoryImpl(Config.resasApi)

}
