package startUp.modules

import com.softwaremill.macwire.wire
import usecase.{DownloadCities, DownloadPrefectures}

trait UsecaseComponent {
  this: InfrastructureComponent =>

  lazy val downloadCities: DownloadCities           = wire[DownloadCities]
  lazy val downloadPrefectures: DownloadPrefectures = wire[DownloadPrefectures]

}
