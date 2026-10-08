# Task Tracker: Spring Boot

## Цель

Применение базовых возможностей Spring Boot на примере небольшого REST API.

Данные хранятся в памяти приложения и теряются после перезапуска.

## Стек

* Java 21
* Gradle
* Spring Boot
* Spring Web

## План

* [x] `init spring boot project`
* [x] `add Task model`
* [x] `add in-memory TaskRepository`
* [x] `add TaskService`
* [x] `add GET /api/tasks`
* [x] `add GET /api/tasks/{id}`
* [ ] `add POST /api/tasks`
* [ ] `add PUT /api/tasks/{id}`
* [ ] `add DELETE /api/tasks/{id}`
* [ ] `add PATCH /api/tasks/{id}/complete`
* [ ] `add request validation`
* [ ] `add global exception handling`
* [ ] `complete README`

## Запуск

```bash
./gradlew bootRun
```

<!--
Приложение доступно по адресу:

```text
http://localhost:8080
```
 -->

## API

### Get all tasks

```text
GET /api/tasks
```

### Get task

```text
GET /api/tasks/{id}
```

### Create task

```text
POST /api/tasks
Content-Type: application/json
```

### Update task

```text
PUT /api/tasks/{id}
Content-Type: application/json
```

### Delete task

```text
DELETE /api/tasks/{id}
```

### Complete task

```text
PATCH /api/tasks/{id}/complete
```

## Архитектура

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
List<Task>
```

<!--
## Что изменилось

Начальный этап проекта. Создано минимальное Spring Boot REST API с хранением данных в памяти.

## Следующий этап

`task-tracker-02-tests-ci`

Добавление тестов и GitHub Actions CI.
-->
