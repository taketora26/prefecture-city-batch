package usecase

import domain.{CityRepository, PrefectureRepository, ResasRepository}
import monix.eval.Task
import util.Logger.logger

class DownloadCities(
    resasRepository: ResasRepository,
    prefectureRepository: PrefectureRepository,
    cityRepository: CityRepository
) {

  def runByAllPrefecture(): Task[Int] = {
    logger.info("start DownloadCities")
    for {
      prefectures <- prefectureRepository.list()
      cities <- Task
                 .sequence(
                   prefectures.map { prefecture =>
                     logger.info(s"start DownloadCities prefecture:$prefecture")
                     resasRepository.getCities(prefecture.prefCode)
                   }
                 )
                 .map(_.flatten)
      result <- cityRepository.save(cities.toList)
    } yield result
  }

  def runByOnePrefectureCode(prefCode: Int): Task[Int] =
    for {
      maybePrefecture <- prefectureRepository.findBy(prefCode)
      cities <- maybePrefecture match {
                 case Some(prefecture) => resasRepository.getCities(prefecture.prefCode)
                 case None             => Task.raiseError(new Exception(s"Nonexistent Code.code:${prefCode}"))
               }
      result <- cityRepository.save(cities.toList)
    } yield result

}
