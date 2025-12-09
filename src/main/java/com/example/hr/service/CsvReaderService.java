package com.example.hr.service;

import com.example.hr.Department;
import com.example.hr.Person;
import com.example.hr.util.DateUtil;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParserBuilder;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Сервис для чтения и обработки CSV файлов с данными сотрудников.
 * Поддерживает различные форматы дат и кэширует подразделения для оптимизации.
 */
public class CsvReaderService {

    /**
     * Читает данные о сотрудниках из CSV файла.
     * Файл должен иметь разделитель ';' и следующий формат:
     * id;name;gender;BirthDate;Division;Salary
     *
     * @param csvFilePath путь к CSV файлу в ресурсах
     * @return список объектов Person, созданных из данных файла
     * @throws IOException если произошла ошибка чтения файла или файл не найден
     */
    public List<Person> readPeopleFromCsv(String csvFilePath) throws IOException {
        List<Person> people = new ArrayList<>();
        Map<String, Department> departmentCache = new HashMap<>();

        char separator = ';';

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath);
             Reader reader = new InputStreamReader(in);
             CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withCSVParser(new CSVParserBuilder()
                        .withSeparator(separator)
                        .build())
                    .build()) {

            if (in == null) {
                throw new FileNotFoundException(csvFilePath);
            }

            String[] nextLine;
            boolean isFirstLine = true;

            while ((nextLine = csvReader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Пропускаем заголовок
                }

                if (nextLine.length >= 6) {
                    Person person = parsePerson(nextLine, departmentCache);
                    if (person != null) {
                        people.add(person);
                    }
                }
            }

        } catch (Exception e) {
            throw new IOException("CSV reading error", e);
        }

        return people;
    }

    /**
     * Преобразует строку CSV в объект Person.
     * Ожидаемый формат: id;name;gender;BirthDate;Division;Salary
     *
     * @param data массив строк с данными сотрудника
     * @param departmentCache кэш подразделений для избежания дублирования
     * @return объект Person или null, если данные некорректны
     */
    private Person parsePerson(String[] data, Map<String, Department> departmentCache) {
        try {
            // Формат строки: id;name;gender;BirtDate;Division;Salary
            int id = Integer.parseInt(data[0].trim());          // id
            String name = data[1].trim();                      // name
            String gender = data[2].trim();                    // gender
            String birthDateStr = data[3].trim();              // BirtDate
            String departmentName = data[4].trim();            // Division
            String salaryStr = data[5].trim().replace(",", "."); // Salary

            double salary = Double.parseDouble(salaryStr);

            // Используем кэш для избежания дублирования объектов Department
            Department department = departmentCache.computeIfAbsent(
                departmentName,
                Department::new
            );

            LocalDate birthDate = null;
            if (!birthDateStr.trim().isEmpty()) {
                birthDate = DateUtil.parseDate(birthDateStr.trim());
            }

            return new Person(id, name, gender, department, salary, birthDate);

        } catch (Exception e) {
            System.err.println("Error parsing line: " + Arrays.toString(data));
            return null;
        }
    }
}