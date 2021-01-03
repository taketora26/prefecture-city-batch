package infrastructure.mysql

import domain.{Prefecture, PrefectureRepository}
import monix.eval.Task
import doobie._
import doobie.implicits.{toSqlInterpolator, _}
import cats.implicits._

class PrefectureRepositoryImpl(mxa: Transactor[Task]) extends PrefectureRepository {

  override def findBy(prefCode: Int): Task[Option[Prefecture]] =
    sql"""select * from prefecture where prefCode = $prefCode""".query[Prefecture].option.transact(mxa)

  override def list(): Task[Seq[Prefecture]] =
    sql"""select * from prefecture""".query[Prefecture].to[Seq].transact(mxa)

  override def save(prefectures: List[Prefecture]): Task[Int] = {
    val sql = "insert into prefecture (prefCode, prefName) values (?, ?)"
    Update[Prefecture](sql).updateMany(prefectures).transact(mxa)
  }
}
