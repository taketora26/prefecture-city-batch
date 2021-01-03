package domain

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

final case class City(prefCode: Int, cityCode: String, cityName: String, bigCityFlag: Int)

object City {
  implicit val decoder: Decoder[City] = deriveDecoder
}
