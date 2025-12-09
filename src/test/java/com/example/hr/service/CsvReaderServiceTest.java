package com.example.hr.service;

import com.example.hr.Person;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CsvReaderServiceTest {

    @Test
    void testReadPeopleFromCsv() throws IOException {
        CsvReaderService csvReader = new CsvReaderService();
        
        List<Person> people = csvReader.readPeopleFromCsv("test_employees.csv");
        
        // ????????? ??? ????????? 4 ????????
        assertEquals(4, people.size());
        
        // ????????? ??????? ????????
        Person firstPerson = people.get(0);
        assertEquals(1, firstPerson.getId());
        assertEquals("John Doe", firstPerson.getName());
        assertEquals("Male", firstPerson.getGender());
        assertEquals("IT", firstPerson.getDepartment().getName());
        assertEquals(50000.0, firstPerson.getSalary(), 0.001);
        assertNotNull(firstPerson.getBirthDate());
        
        // ????????? ??? ?????? ??????? ?????????
        // ??? ???????? ?? IT ?????? ????? ???? ? ??? ?? ?????? Department
        Person firstIT = people.get(0);
        Person secondIT = people.get(2);
        assertEquals(firstIT.getDepartment(), secondIT.getDepartment());
        
        // ????????? ??? ????? HR ??????
        Person hrPerson = people.get(1);
        assertEquals("HR", hrPerson.getDepartment().getName());
        
        // ????????? ??? ????? Finance ??????
        Person financePerson = people.get(3);
        assertEquals("Finance", financePerson.getDepartment().getName());
    }

    @Test
    void testReadNonexistentFile() {
        CsvReaderService csvReader = new CsvReaderService();
        
        assertThrows(IOException.class, () -> {
            csvReader.readPeopleFromCsv("nonexistent.csv");
        });
    }
    
    @Test
    void testReadEmptyFile() throws IOException {
        // ??????? ?????? ???? ??? ?????
        // (????? ??????? ???? empty.csv ? test/resources)
        
        CsvReaderService csvReader = new CsvReaderService();
        List<Person> people = csvReader.readPeopleFromCsv("empty.csv");
        
        assertTrue(people.isEmpty());
    }
}
