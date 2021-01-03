This is an application that Japanese Prefecture and city download.

you need to resister [RESAS](https://opendata.resas-portal.go.jp/docs/api/v1/index.html).

## environment variable
you need to set below environment variable.

- DB_DEFAULT_URL
- DB_TEST_URL
- DB_DEFAULT_USER
- DB_DEFAULT_PASSWORD
- RESAS_API_KEY
- RESAS_URL

## setting up
- setup mysql

```shell
$ docker/docker-compose up -d
```

```shell
$ sbt flywayMigrate
```

## Using Library
- MONIX
- Doobie
- STTP


## RUN BATCH

```shell
$ sbt "runMain startUp.batch.PrefectureCityDownloadBatch"
```