package infrastructure.http.resas

import domain.{City, Prefecture, ResasRepository}
import infrastructure.http.resas.response.{CitiesResponseModel, PrefecturesResponseModel}
import monix.eval.Task
import startUp.Config.ResasApi
import sttp.client3.asynchttpclient.monix.AsyncHttpClientMonixBackend
import sttp.client3._
import sttp.client3.circe._

class ResasRepositoryImpl(resasApi: ResasApi) extends ResasRepository {

  override def getPrefectures(): Task[Seq[Prefecture]] = {
    val uri = resasApi.url + "prefectures"
    val request =
      basicRequest
        .header("X-API-KEY", resasApi.xApiKey)
        .get(uri"$uri")
        .response(asJson[PrefecturesResponseModel])

    AsyncHttpClientMonixBackend().flatMap(backend =>
      request
        .send(backend)
        .map(v =>
          v.body match {
            case Left(error)     => throw error
            case Right(response) => response.result
          }
        )
        .guarantee(backend.close())
    )
  }

  override def getCities(prefCode: Int): Task[Seq[City]] = {
    val uri = resasApi.url + s"cities?prefCode=$prefCode"
    val request =
      basicRequest
        .header("X-API-KEY", resasApi.xApiKey)
        .get(uri"$uri")
        .response(asJson[CitiesResponseModel])

    AsyncHttpClientMonixBackend().flatMap(backend =>
      request
        .send(backend)
        .map(v =>
          v.body match {
            case Left(error)     => throw error
            case Right(response) => response.result
          }
        )
        .guarantee(backend.close())
    )
  }

}
