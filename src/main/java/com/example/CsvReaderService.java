package com.example;

import com.opencsv.CSVReader;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CsvReaderService {
    private static final char SEPARATOR = ';';
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    
    public List<Person> readPeopleFromCsv(String csvFilePath) throws IOException {
        List<Person> people = new ArrayList<>();
        Map<String, Department> departmentsCache = new HashMap<>();
        
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath);
             CSVReader reader = in == null ? null : new CSVReader(new InputStreamReader(in))) {
            
            if (reader == null) {
                throw new FileNotFoundException(csvFilePath);
            }
            
            // Пропускаем заголовок
            String[] header = reader.readNext();
            System.out.println("Header: " + Arrays.toString(header));
            
            String[] nextLine;
            int lineNumber = 0;
            while ((nextLine = reader.readNext()) != null) {
                lineNumber++;
                
                if (nextLine.length > 0 && nextLine[0] != null && !nextLine[0].trim().isEmpty()) {
                    // Объединяем и разбиваем по разделителю
                    String line = String.join("", nextLine);
                    String[] parts = line.split(String.valueOf(SEPARATOR), -1);
                    
                    if (parts.length >= 6) {
                        Person person = parsePerson(parts, departmentsCache);
                        if (person != null) {
                            people.add(person);
                        }
                    }
                }
            }
            
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
        
        return people;
    }
    
    private Person parsePerson(String[] data, Map<String, Department> departmentsCache) {
        try {
            int id = Integer.parseInt(data[0].trim());
            String name = data[1].trim();
            String gender = data[2].trim();
            String departmentName = data[3].trim();
            double salary = Double.parseDouble(data[4].trim().replace(",", "."));
            LocalDate birthDate = LocalDate.parse(data[5].trim(), DATE_FORMATTER);
            
            Department department = departmentsCache.computeIfAbsent(departmentName, Department::new);
            
            return new Person(id, name, gender, department, salary, birthDate);
            
        } catch (Exception e) {
            System.err.println("Parse error for data: " + Arrays.toString(data));
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }
}