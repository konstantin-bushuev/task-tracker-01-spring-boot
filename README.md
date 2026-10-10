# Task Tracker: Spring Boot

## Цель

Применение базовых возможностей Spring Boot на примере небольшого REST API.

Данные хранятся в памяти приложения и теряются после перезапуска.

## Стек

* Java 21
* Gradle (Kotlin DSL)
* Spring Boot
* Spring Web
* Bean Validation

## План

* [x] `init spring boot project`
* [x] `add Task model`
* [x] `add in-memory TaskRepository`
* [x] `add TaskService`
* [x] `add GET /api/tasks`
* [x] `add GET /api/tasks/{id}`
* [x] `add POST /api/tasks`
* [x] `add PUT /api/tasks/{id}`
* [x] `add DELETE /api/tasks/{id}`
* [x] `add PATCH /api/tasks/{id}/complete`
* [x] `add request validation`
* [x] `add global exception handling`
* [x] `complete README`

## Запуск

1. Требуется установленная Java 21

2. Клонировать репозиторий

3. Сборка и проверка:
```bash
./gradlew build
```

4. Запуск:
```bash
./gradlew bootRun
```

Приложение запускается по адресу http://localhost:8080

## API


| Метод | Endpoint | Описание |
|---|---|---|
| GET | `/api/tasks` | Получить все задачи |
| GET | `/api/tasks/{id}` | Получить задачу по id |
| POST | `/api/tasks` | Создать задачу |
| PUT | `/api/tasks/{id}` | Обновить задачу |
| DELETE | `/api/tasks/{id}` | Удалить задачу |
| PATCH | `/api/tasks/{id}/complete` | Завершить задачу |

Для `POST` и `PUT` используется JSON:

```json
{
  "title": "Task title",
  "description": "Task description"
}
```

- `title` — обязательное поле, максимум 30 символов.
- `description` — необязательное поле, максимум 100 символов.

Новые задачи создаются со статусом `TODO`.

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
## Структура проекта

```text
src/main/java/io/github/konstantinbushuev/tasktracker01springboot/
├── model
│   ├── Task.java                       # модель данных
│   └── TaskStatus.java                 # статусы задач   
├── dto
│   ├── TaskRequestDTO.java             # входные данные для запросов
│   └── ErrorResponse.java              # формат ошибок  
├── repository
│   └── TaskRepository.java             # хранение задач в памяти
├── service
│   └── TaskService.java                # бизнес-логика
├── controller
│   └── TaskController.java             # HTTP endpoints
└── exception/                      
    ├── GlobalExceptionHandler.java     # глобальная обработка ошибок API
    └── TaskNotFoundException.java      # исключение для ненайденной задачи    
        
```

## Следующий этап

[task-tracker-02-tests-ci](https://github.com/konstantin-bushuev/task-tracker-02-tests-ci)

Добавление тестов и GitHub Actions CI.