package usecase

import domain.{PrefectureRepository, ResasRepository}
import monix.eval.Task
import util.Logger.logger

class DownloadPrefectures(val resasRepository: ResasRepository, val prefectureRepository: PrefectureRepository) {

  def run(): Task[Int] = {
    println(resasRepository)
    println(prefectureRepository)
    logger.info("start DownloadPrefectures")
    for {
      prefectures <- resasRepository.getPrefectures()
      result      <- prefectureRepository.save(prefectures.toList)
    } yield {
      logger.info("finish DownloadPrefectures")
      result
    }
  }

}
