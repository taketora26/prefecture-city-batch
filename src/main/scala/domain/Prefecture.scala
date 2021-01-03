package domain

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

final case class Prefecture(prefCode: Int, prefName: String)

object Prefecture {
  implicit val decoder: Decoder[Prefecture] = deriveDecoder
}
