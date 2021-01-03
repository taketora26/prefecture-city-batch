package domain

import monix.eval.Task

trait ResasRepository {

  def getPrefectures(): Task[Seq[Prefecture]]
  def getCities(prefCode: Int): Task[Seq[City]]

}
