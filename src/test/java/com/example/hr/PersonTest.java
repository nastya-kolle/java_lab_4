package com.example.hr;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testPersonCreation() {
        Department dept = new Department("IT");
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        
        Person person = new Person(1, "John Doe", "Male", dept, 50000.0, birthDate);
        
        assertEquals(1, person.getId());
        assertEquals("John Doe", person.getName());
        assertEquals("Male", person.getGender());
        assertEquals(dept, person.getDepartment());
        assertEquals(50000.0, person.getSalary(), 0.001);
        assertEquals(birthDate, person.getBirthDate());
    }

    @Test
    void testEqualsAndHashCode() {
        Department dept1 = new Department("IT");
        Department dept2 = new Department("HR");
        
        Person person1 = new Person(1, "John", "Male", dept1, 50000.0, null);
        Person person2 = new Person(1, "Jane", "Female", dept2, 60000.0, null);
        Person person3 = new Person(2, "John", "Male", dept1, 50000.0, null);
        
        // ??? ???????? ? ?????????? ID ?????? ???? ?????
        assertEquals(person1, person2);
        assertNotEquals(person1, person3);
        
        // ???-??? ?????? ???? ?????????? ??? ?????? ????????
        assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    void testSetters() {
        Person person = new Person();
        Department dept = new Department("Finance");
        LocalDate birthDate = LocalDate.of(1985, 10, 20);
        
        person.setId(100);
        person.setName("Alice");
        person.setGender("Female");
        person.setDepartment(dept);
        person.setSalary(75000.0);
        person.setBirthDate(birthDate);
        
        assertEquals(100, person.getId());
        assertEquals("Alice", person.getName());
        assertEquals("Female", person.getGender());
        assertEquals(dept, person.getDepartment());
        assertEquals(75000.0, person.getSalary(), 0.001);
        assertEquals(birthDate, person.getBirthDate());
    }
}
