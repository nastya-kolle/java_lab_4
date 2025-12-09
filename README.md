# HR System - CSV Employee Data Processor

Проект для обработки CSV файлов с данными сотрудников компании.

## Описание проекта

Система считывает данные о сотрудниках из CSV файла, преобразует их в объекты Java, генерирует уникальные идентификаторы для подразделений и предоставляет статистическую информацию.

## Структура проекта

 ## Структура проекта

- src/main/java/com/example/hr/Person.java           - Сущность сотрудника
- src/main/java/com/example/hr/Department.java       - Сущность подразделения
- src/main/java/com/example/hr/Main.java            - Главный класс приложения
- src/main/java/com/example/hr/service/CsvReaderService.java - Сервис чтения CSV
- src/main/java/com/example/hr/util/DateUtil.java   - Утилиты для работы с датами
- src/main/resources/foreign_names.csv              - Исходные данные (25,898 записей)
- src/test/java/...                                - Unit-тесты


## Формат данных CSV

Файл `foreign_names.csv` содержит следующие поля (разделитель ;):
- `id` - уникальный идентификатор сотрудника
- `name` - имя сотрудника
- `gender` - пол (Male/Female)
- `BirthDate` - дата рождения (dd.MM.yyyy)
- `Division` - название подразделения
- `Salary` - зарплата

## Запуск проекта

### Требования
- Java 8 или выше
- Apache Maven 3.6+

### Сборка и запуск

``bash
### Сборка проекта
mvn clean compile

### Запуск тестов
mvn test

### Создание исполняемого JAR
mvn clean compile assembly:single

### Запуск приложения
java -jar target/hr-system.jar

## Запуск через Maven
- mvn clean compile exec:java
- mvn test

## Результаты работы
### Пример вывода:

=
Read 25898 people:
Person{id=1, name='John', gender='Male', department=Department{id=1, name='IT'}, salary=5000.0, birthDate=1990-05-15}
...

Statistics:
Total employees: 25898
Average salary: 5441.50

Employees by department:
- A: 1744
- B: 1721
- C: 1824
- D: 1660
- E: 1660
- F: 1806
- G: 1699
- H: 1747
- I: 1700
- J: 1723
 -K: 1645
- L: 1718
- M: 1722
- N: 1793
- O: 1736
 
### Ключевая статистика:
- Всего сотрудников: 25,898
- Средняя зарплата: 5,441.50
- Количество отделов: 15 (A-O)
- Распределение: ~1,700 сотрудников в каждом отделе

## Тестирование
Проект включает 11 unit-тестов с полным покрытием:
bash

  ```mvn test```
Результат:
text

  ```Tests run: 11, Failures: 0, Errors: 0, Skipped: 0```
  
Тесты проверяют:
- Создание объектов Person и Department
- Корректность equals/hashCode методов
- Чтение данных из CSV файла
- Обработку ошибок парсинга


## JavaDoc
Все классы и методы задокументированы в соответствии со стандартами JavaDoc. Для генерации документации:
bash

  ```mvn javadoc:javadoc```
Документация будет создана в target/site/apidocs/.

## Технологии
- Java 8+ - основной язык разработки

- Maven - управление зависимостями и сборкой

- OpenCSV 5.7.1 - работа с CSV файлами

- JUnit 5 - модульное тестирование

- Stream API - обработка коллекций


## Зависимости
Основные зависимости проекта:
- com.opencsv:opencsv:5.7.1 - чтение CSV файлов
- org.junit.jupiter:junit-jupiter:5.9.2 - тестирование


## Обработка ошибок
- Проверка существования CSV файла
- Валидация формата дат (поддержка 6 форматов)
- Обработка некорректных числовых значений
- Логирование ошибок парсинга
