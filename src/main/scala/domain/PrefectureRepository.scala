package domain

import monix.eval.Task

trait PrefectureRepository {

  def list(): Task[Seq[Prefecture]]
  def findBy(prefCode: Int): Task[Option[Prefecture]]
  def save(prefectures: List[Prefecture]): Task[Int]

}
