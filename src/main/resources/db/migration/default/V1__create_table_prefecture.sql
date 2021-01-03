CREATE TABLE `prefecture` (
`prefCode` INT(2) NOT NULL,
`prefName` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`prefCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;


CREATE TABLE `city` (
`prefCode` INT(2) NOT NULL,
`cityCode` INT(5) NOT NULL,
`cityName` VARCHAR(256) NOT NULL,
`bigCityFlag` INT(1) NOT NULL,
  PRIMARY KEY (`prefCode`,`cityCode`),
  FOREIGN KEY(`prefCode`) REFERENCES prefecture(`prefCode`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
