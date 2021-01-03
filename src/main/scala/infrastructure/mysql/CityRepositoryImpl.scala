package infrastructure.mysql

import domain.{City, CityRepository}
import doobie._
import doobie.implicits.{toSqlInterpolator, _}
import cats.implicits._
import monix.eval.Task

class CityRepositoryImpl(mxa: Transactor[Task]) extends CityRepository {

  override def findBy(prefCode: Int, cityCode: Long): Task[Option[City]] =
    sql"""select * from city where prefCode = $prefCode and cityCode = $cityCode""".query[City].option.transact(mxa)

  override def list(): Task[Seq[City]] =
    sql"""select * from city""".query[City].to[Seq].transact(mxa)

  override def list(prefCode: Int): Task[Seq[City]] =
    sql"""select * from city where prefCode = $prefCode""".query[City].to[Seq].transact(mxa)

  override def save(city: City): Task[Int] =
    sql"""insert into city (prefCode, cityCode, cityName, bigCityFlag) values (${city.prefCode},${city.cityCode}, ${city.cityName}, ${city.bigCityFlag})""".update.run
      .transact(mxa)

  override def save(cities: List[City]): Task[Int] = {
    val sql = "insert into city (prefCode, cityCode, cityName, bigCityFlag) values (?, ?, ?, ?)"
    Update[City](sql).updateMany(cities).transact(mxa)
  }

}
