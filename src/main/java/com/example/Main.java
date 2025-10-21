

import java.io.IOException;
import java.util.List;

package com.example;

public class Main {
    public static void main(String[] args) {
        CsvReaderService readerService = new CsvReaderService();
        
        try {
            System.out.println("=== STARTING APPLICATION ===");
            
            // Убедитесь что имя файла правильное
            List<Person> people = readerService.readPeopleFromCsv("people.csv");
            
            System.out.println("=== FINAL RESULT ===");
            System.out.println("Total people read: " + people.size());
            
            if (people.isEmpty()) {
                System.out.println("WARNING: No people were read from the file!");
            } else {
                System.out.println("\nPeople list:");
                for (Person person : people) {
                    System.out.println(person);
                }
            }
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

/*
package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World! Program is working.");
    }
}
*/