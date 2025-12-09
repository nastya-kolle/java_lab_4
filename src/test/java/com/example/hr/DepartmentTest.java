package com.example.hr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void testDepartmentCreation() {
        Department dept = new Department("IT");
        
        assertEquals("IT", dept.getName());
        assertTrue(dept.getId() > 0); 
    }

    @Test
    void testAutoIncrementId() {
        
        Department dept1 = new Department("IT");
        Department dept2 = new Department("HR");
        Department dept3 = new Department("Finance");

        assertNotEquals(dept1.getId(), dept2.getId());
        assertNotEquals(dept2.getId(), dept3.getId());
        assertNotEquals(dept1.getId(), dept3.getId());
    }

    @Test
    void testEqualsAndHashCode() {
        Department dept1 = new Department("IT");
        Department dept2 = new Department("IT"); 
        Department dept3 = new Department("HR");
        
        assertNotEquals(dept1, dept2); 
        
        Department dept4 = new Department("IT");
        dept4.setId(dept1.getId());
        
        assertEquals(dept1, dept4);
        assertEquals(dept1.hashCode(), dept4.hashCode());
    }

    @Test
    void testSetters() {
        Department dept = new Department();
        
        dept.setId(10);
        dept.setName("Marketing");
        
        assertEquals(10, dept.getId());
        assertEquals("Marketing", dept.getName());
    }
    
    @Test
    void testToString() {
        Department dept = new Department("IT");
        dept.setId(5);
        
        String toString = dept.toString();
        assertTrue(toString.contains("Department"));
        assertTrue(toString.contains("id=5"));
        assertTrue(toString.contains("name='IT'"));
    }
}
