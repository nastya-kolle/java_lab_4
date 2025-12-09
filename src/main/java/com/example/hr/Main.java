package com.example.hr;

import com.example.hr.service.CsvReaderService;
import java.io.IOException;
import java.util.List;

/**
 * Главный класс приложения для обработки данных сотрудников.
 * Считывает данные из CSV файла, выводит информацию о сотрудниках
 * и статистику по подразделениям и зарплатам.
 */
public class Main {
    
    /**
     * Точка входа в приложение.
     * Читает данные из CSV файла, выводит список сотрудников
     * и статистическую информацию.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        CsvReaderService csvReader = new CsvReaderService();

        try {
            // Чтение данных из CSV файла
            List<Person> people = csvReader.readPeopleFromCsv("foreign_names.csv");

            System.out.println("Read " + people.size() + " people:");
            System.out.println("======================================");

            // Вывод информации о каждом сотруднике
            for (Person person : people) {
                System.out.println(person);
            }

            // Вывод статистики
            printStatistics(people);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Выводит статистическую информацию по сотрудникам:
     * - Общее количество сотрудников
     * - Среднюю зарплату
     * - Количество сотрудников по подразделениям
     *
     * @param people список сотрудников для анализа
     */
    private static void printStatistics(List<Person> people) {
        System.out.println("\nStatistics:");
        System.out.println("======================================");
        System.out.println("Total employees: " + people.size());

        if (!people.isEmpty()) {
            // Расчет средней зарплаты
            double totalSalary = 0;
            for (Person p : people) {
                totalSalary += p.getSalary();
            }
            double avgSalary = totalSalary / people.size();

            System.out.println("Average salary: " + String.format("%.2f", avgSalary));

            // Распределение по подразделениям
            System.out.println("\nEmployees by department:");
            java.util.Map<String, Integer> deptCount = new java.util.HashMap<>();
            for (Person p : people) {
                String dept = p.getDepartment().getName();
                deptCount.put(dept, deptCount.getOrDefault(dept, 0) + 1);
            }
            for (java.util.Map.Entry<String, Integer> entry : deptCount.entrySet()) {
                System.out.println("  " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}