# URLshort
Сервис для сокращения интернет-ссылок

## Installation
Приложение состоит из сервисов базы данных postgres, миграции базы данных flyway и бекенда, управляемых при помощи docker compose

Требования:
- maven
- docker-compose

Сборка бекенда

```sh
$ mvn -pl backend package
```
Запуск
```sh
$ docker-compose up
```
При первом запуске произойдет скачивание и создание необходимых докер образов. Перед запуском в файле .env можно изменить параметры базы данных и данные для подключения

| Переменная | Описание |
| ------ | ------ |
| POSTGRES_USER | Имя суперюзера |
| POSTGRES_PASSWORD | Пароль суперюзера |
| POSTGRES_DB | Название базы данных |
| DB_PORT | Порт для доступа к базе данных |
| BACKEND_PORT | Порт для доступа к бекенду |
Узнать ip адрес контейнера
```sh
$ docker ps -a
$ docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' *container id*
```
## Usage
Взаимодействие с API бекенда:
- Сгенерировать короткую ссылку
```sh
$ curl -X POST "http://ip:port/api/url/generate_short_url?full_url=https://www.youtube.com"
vbply
```
- Перейти по короткой ссылке
```sh
$ curl -i -X GET "http://ip:port/vbply"
HTTP/1.1 302 
Location: https://www.youtube.com
Content-Language: en-US
Content-Length: 0
Date: Sat, 12 Feb 2022 04:22:02 GMT
```
## Development
В директории db_migration/scripts содержатся файлы с sql запросами для автоматической миграции базы данных. При добавлении новых файлов нужно запустить сервис миграции
```sh
$ docker-compose up flyway
```
При изменении бекенда требуется собрать новый jar архив и выполнить следующую команду:
```sh
$ docker-compose up --detach --build
```
При запуске бекенда и миграции вне контейнера необходимо определить переменные среды в файлах db_migration/pom.xml и backend/src/main/resources/application.properties
Flyway также доступен напрямую через maven плагин:
```sh
$ mvn -pl db_migration flyway:migrate
```