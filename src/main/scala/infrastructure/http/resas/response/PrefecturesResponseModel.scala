package infrastructure.http.resas.response

import domain.Prefecture
import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

case class PrefecturesResponseModel(message: Option[String], result: Seq[Prefecture])

object PrefecturesResponseModel {
  implicit val decoder: Decoder[PrefecturesResponseModel] = deriveDecoder[PrefecturesResponseModel]
}
