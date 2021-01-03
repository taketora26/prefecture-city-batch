package domain

import monix.eval.Task

trait CityRepository {
  def list(): Task[Seq[City]]
  def findBy(prefCode: Int, cityCode: Long): Task[Option[City]]
  def list(prefCode: Int): Task[Seq[City]]
  def save(city: City): Task[Int]
  def save(cities: List[City]): Task[Int]

}
