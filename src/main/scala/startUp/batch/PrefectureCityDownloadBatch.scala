package startUp.batch

import monix.eval.Task
import startUp.modules.{InfrastructureComponent, UsecaseComponent}
import util.Logger.logger
import monix.execution.Scheduler.Implicits.global

object PrefectureCityDownloadBatch extends UsecaseComponent with InfrastructureComponent {

  def main(args: Array[String]): Unit = {
    val myTask: Task[(Int, Int)] = for {
      downloadPrefectures <- downloadPrefectures.run()
      runByAllPrefecture  <- downloadCities.runByAllPrefecture()
    } yield (downloadPrefectures, runByAllPrefecture)

    logger.info("start PrefectureCityDownloadBatch")
    myTask.runAsync {
      case Left(value) => logger.error(s" failed task ${value.getMessage}")
      case Right(value) =>
        logger.info(
          s"finish PrefectureCityDownloadBatch. downloadPrefectures:${value._1}, runByAllPrefecture:${value._2}"
        )
    }
  }
}
