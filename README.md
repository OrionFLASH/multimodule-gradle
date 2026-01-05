# Многомодульный проект Gradle

## Описание проекта

Данный проект представляет собой учебный многомодульный проект, созданный с использованием Gradle. Проект демонстрирует организацию кода в модульной архитектуре с четким разделением ответственности между модулями по функциональности.

## Техническое задание

### Задача 2: Многомодульный проект на Gradle

Для закрепления лекционного материала необходимо создать многомодульный проект на Gradle.

Стандартный многомодульный проект имеет составляющие по функционалу:

- **db** - модуль работы с базой данных
- **api** - модуль работы с web
- **service** - слой сервисов

### Требования к реализации

1. Создать 3 модуля в корневой директории проекта: `db`, `api`, `service`
2. Настроить зависимости между модулями:
   - Модуль `service` зависит от модуля `db`
   - Модуль `api` зависит от модулей `db` и `service`
3. Реализовать классы согласно заданию в каждом модуле
4. Обеспечить возможность сборки проекта командой `gradle build`

## Структура проекта

```
multimodule-gradle/
├── settings.gradle         # Настройки проекта и список модулей
├── build.gradle            # Родительский build.gradle
├── db/                     # Модуль работы с базой данных
│   ├── build.gradle
│   └── src/
│       └── main/java/ru/netology/db/
│           ├── DbSetting.java
│           ├── MyEntity.java
│           └── Db.java
├── service/                # Модуль сервисов
│   ├── build.gradle
│   └── src/
│       └── main/java/ru/netology/service/
│           └── MyService.java
└── api/                    # Модуль работы с web
    ├── build.gradle
    └── src/
        └── main/java/ru/netology/api/
            └── Main.java
```

## Описание решения

### settings.gradle

Определяет корневой проект и список всех модулей:

```groovy
rootProject.name = 'multimodule-gradle'

include 'db'
include 'service'
include 'api'
```

### Родительский build.gradle

Содержит общие настройки для всех модулей:
- Применение Java плагина
- Версия Java: 11
- Кодировка: UTF-8
- Зависимости: JUnit 5 для тестирования

### Модуль db

Модуль работы с базой данных. Содержит классы для работы с настройками подключения и сущностями.

#### Класс DbSetting

Класс для хранения настроек базы данных. Содержит имя и пароль для подключения к БД.

**Конструктор:**
- `DbSetting(String name, String password)` - создает настройки подключения к БД
  - `name` - имя пользователя для подключения к БД
  - `password` - пароль для подключения к БД

**Пример использования:**
```java
DbSetting dbSetting = new DbSetting("name", "password");
```

#### Класс MyEntity

Класс сущности для работы с базой данных. Представляет объект с уникальным идентификатором и именем.

**Конструктор:**
- `MyEntity(String name)` - создает сущность с указанным именем
  - `name` - имя сущности

**Методы:**
- `UUID getId()` - получить уникальный идентификатор сущности
- `void setId(UUID id)` - установить уникальный идентификатор сущности
- `String getName()` - получить имя сущности
- `void setName(String name)` - установить имя сущности
- `String toString()` - преобразование объекта в строковое представление

**Пример использования:**
```java
MyEntity entity = new MyEntity("test");
entity.setId(UUID.randomUUID());
System.out.println(entity.getName()); // "test"
```

#### Класс Db

Класс для работы с базой данных. Управляет настройками подключения и сущностями.

**Конструктор:**
- `Db(DbSetting dbSetting)` - создает объект базы данных с указанными настройками
  - `dbSetting` - настройки подключения к базе данных
  - При создании автоматически создается сущность "first" с случайным UUID

**Методы:**
- `DbSetting getDbSetting()` - получить настройки подключения к базе данных
- `MyEntity getMyEntity()` - получить текущую сущность из базы данных
- `void setMyEntity(MyEntity myEntity)` - установить новую сущность в базу данных

**Пример использования:**
```java
DbSetting dbSetting = new DbSetting("name", "password");
Db db = new Db(dbSetting);
MyEntity entity = db.getMyEntity();
```

### Модуль service

Модуль сервисов. Содержит бизнес-логику приложения. Зависит от модуля `db`.

#### Класс MyService

Сервисный класс для работы с бизнес-логикой. Использует модуль db для работы с базой данных.

**Поля:**
- `DbSetting dbSetting` - настройки подключения к БД (инициализируется как "name", "password")
- `String name` - имя сервиса (инициализируется как "myService")
- `Db db` - объект базы данных

**Методы:**
- `String getName()` - получить имя сервиса
- `MyEntity setMyEntity(MyEntity myEntity)` - установить новую сущность в базу данных
  - Автоматически генерирует UUID для новой сущности
  - Сохраняет сущность в базу данных
  - Возвращает сохраненную сущность с установленным UUID
- `MyEntity getMyEntity()` - получить текущую сущность из базы данных

**Пример использования:**
```java
MyService myService = new MyService();
MyEntity entity = myService.getMyEntity();
MyEntity newEntity = myService.setMyEntity(new MyEntity("second"));
```

### Модуль api

Модуль работы с web. Главный модуль приложения, демонстрирующий использование всех модулей. Зависит от модулей `db` и `service`.

#### Класс Main

Главный класс приложения. Демонстрирует работу многомодульного проекта.

**Методы:**
- `public static void main(String[] args)` - точка входа в приложение
  - Создает экземпляр MyService
  - Получает текущую сущность из базы данных и выводит её
  - Устанавливает новую сущность "second" и выводит её
  - Получает обновленную сущность из базы данных и выводит её

**Пример использования:**
```java
MyService myService = new MyService();
System.out.println(myService.getMyEntity());
System.out.println(myService.setMyEntity(new MyEntity("second")));
System.out.println(myService.getMyEntity());
```

## Зависимости между модулями

Зависимости настроены в файлах `build.gradle` каждого модуля:

### Модуль db (build.gradle)

```groovy
plugins {
    id 'java'
}

group 'ru.netology'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    // Модуль db не имеет зависимостей от других модулей проекта
}
```

### Модуль service (build.gradle)

```groovy
plugins {
    id 'java'
}

group 'ru.netology'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    // Зависимость от модуля db
    implementation project(":db")
}
```

### Модуль api (build.gradle)

```groovy
plugins {
    id 'java'
}

group 'ru.netology'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    // Зависимости от других модулей проекта
    implementation project(":db")
    implementation project(":service")
}
```

## Используемые инструменты

- **Gradle** - система сборки и управления зависимостями
- **Java 11** - язык программирования
- **JUnit 5** - фреймворк для тестирования (настроен в родительском build.gradle)

## Полный список классов и функций

### ru.netology.db.DbSetting

Класс для хранения настроек базы данных.

**Конструкторы:**
- `public DbSetting(String name, String password)` - создает настройки подключения к БД

**Поля:**
- `private String name` - имя пользователя для подключения к БД
- `private String password` - пароль для подключения к БД

### ru.netology.db.MyEntity

Класс сущности для работы с базой данных.

**Конструкторы:**
- `public MyEntity(String name)` - создает сущность с указанным именем

**Поля:**
- `private UUID id` - уникальный идентификатор сущности
- `private String name` - имя сущности

**Методы:**
- `public UUID getId()` - получить уникальный идентификатор сущности
- `public void setId(UUID id)` - установить уникальный идентификатор сущности
- `public String getName()` - получить имя сущности
- `public void setName(String name)` - установить имя сущности
- `public String toString()` - преобразование объекта в строковое представление

### ru.netology.db.Db

Класс для работы с базой данных.

**Конструкторы:**
- `public Db(DbSetting dbSetting)` - создает объект базы данных с указанными настройками

**Поля:**
- `private DbSetting dbSetting` - настройки подключения к базе данных
- `private MyEntity myEntity` - текущая сущность в базе данных

**Методы:**
- `public DbSetting getDbSetting()` - получить настройки подключения к базе данных
- `public MyEntity getMyEntity()` - получить текущую сущность из базы данных
- `public void setMyEntity(MyEntity myEntity)` - установить новую сущность в базу данных

### ru.netology.service.MyService

Сервисный класс для работы с бизнес-логикой.

**Поля:**
- `private DbSetting dbSetting` - настройки подключения к БД (инициализируется как "name", "password")
- `private String name` - имя сервиса (инициализируется как "myService")
- `private Db db` - объект базы данных

**Методы:**
- `public String getName()` - получить имя сервиса
- `public MyEntity setMyEntity(MyEntity myEntity)` - установить новую сущность в базу данных
- `public MyEntity getMyEntity()` - получить текущую сущность из базы данных

### ru.netology.api.Main

Главный класс приложения.

**Методы:**
- `public static void main(String[] args)` - точка входа в приложение

## Сборка проекта

Для сборки проекта выполните команду:

```bash
gradle build
```

Или с использованием Gradle Wrapper:

```bash
./gradlew build
```

Для запуска приложения (если настроен плагин application):

```bash
./gradlew :api:run
```

Для запуска тестов:

```bash
./gradlew test
```

## История версий

### Версия 2.0

**Реализовано:**
- Переработана структура проекта согласно заданию
- Создан модуль `db` с классами `DbSetting`, `MyEntity`, `Db`
- Обновлен модуль `service` с классом `MyService`
- Переименован модуль `app` в `api` с классом `Main`
- Настроены зависимости между модулями согласно заданию:
  - `service` зависит от `db`
  - `api` зависит от `db` и `service`
- Добавлены подробные комментарии на русском языке ко всем классам и методам
- Обновлена документация с полным описанием всех классов и методов

**Решенные проблемы:**
- Исправлена структура модулей: заменены `utils`, `app` на `db`, `api` согласно заданию
- Удалены классы, не соответствующие заданию (`NumberUtils`, `MathService`)
- Настроены корректные зависимости между модулями через Gradle
- Реализованы все классы точно согласно техническому заданию
- Обновлена документация с актуальной информацией о проекте

### Версия 1.0

**Реализовано:**
- Создана структура многомодульного проекта
- Реализован модуль utils с классом NumberUtils
- Реализован модуль service с классом MathService
- Реализован модуль app с главным классом Main
- Написаны тесты для всех модулей
- Настроены зависимости между модулями
- Настроен плагин application для запуска приложения

**Решенные проблемы:**
- Настроена корректная иерархия зависимостей между модулями через Gradle
- Реализована обработка исключений при некорректных входных данных
- Добавлены комментарии на русском языке ко всем классам и методам
- Настроен манифест для создания исполняемого JAR
