package infrastructure.http.resas.response

import domain.City
import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

case class CitiesResponseModel(message: Option[String], result: Seq[City])

object CitiesResponseModel {
  implicit val decoder: Decoder[CitiesResponseModel] = deriveDecoder[CitiesResponseModel]
}
