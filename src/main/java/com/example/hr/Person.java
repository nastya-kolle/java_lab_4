package com.example.hr;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Класс, представляющий сотрудника компании.
 * Содержит информацию о человеке: идентификатор, имя, пол, подразделение,
 * зарплату и дату рождения.
 */
public class Person {
    private int id;
    private String name;
    private String gender;
    private Department department;
    private double salary;
    private LocalDate birthDate;

    /**
     * Конструктор по умолчанию для создания пустого объекта Person.
     * Используется фреймворками и библиотеками.
     */
    public Person() {}

    /**
     * Конструктор для создания объекта Person со всеми полями.
     *
     * @param id уникальный идентификатор сотрудника
     * @param name имя сотрудника
     * @param gender пол сотрудника
     * @param department подразделение сотрудника
     * @param salary зарплата сотрудника
     * @param birthDate дата рождения сотрудника
     */
    public Person(int id, String name, String gender, Department department,
                  double salary, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    /**
     * Возвращает уникальный идентификатор сотрудника.
     *
     * @return идентификатор сотрудника
     */
    public int getId() { return id; }

    /**
     * Устанавливает уникальный идентификатор сотрудника.
     *
     * @param id новый идентификатор сотрудника
     */
    public void setId(int id) { this.id = id; }

    /**
     * Возвращает имя сотрудника.
     *
     * @return имя сотрудника
     */
    public String getName() { return name; }

    /**
     * Устанавливает имя сотрудника.
     *
     * @param name новое имя сотрудника
     */
    public void setName(String name) { this.name = name; }
    
    /**
     * Возвращает пол сотрудника.
     *
     * @return пол сотрудника (например, "Male" или "Female")
     */
    public String getGender() { return gender; }

    /**
     * Устанавливает пол сотрудника.
     *
     * @param gender новый пол сотрудника
     */
    public void setGender(String gender) { this.gender = gender; }

    /**
     * Возвращает подразделение сотрудника.
     *
     * @return объект подразделения
     */
    public Department getDepartment() { return department; }

    /**
     * Устанавливает подразделение сотрудника.
     *
     * @param department новое подразделение сотрудника
     */
    public void setDepartment(Department department) { this.department = department; }

    /**
     * Возвращает зарплату сотрудника.
     *
     * @return зарплата сотрудника
     */
    public double getSalary() { return salary; }

    /**
     * Устанавливает зарплату сотрудника.
     *
     * @param salary новая зарплата сотрудника
     */
    public void setSalary(double salary) { this.salary = salary; }

    /**
     * Возвращает дату рождения сотрудника.
     *
     * @return дата рождения сотрудника
     */
    public LocalDate getBirthDate() { return birthDate; }

    /**
     * Устанавливает дату рождения сотрудника.
     *
     * @param birthDate новая дата рождения сотрудника
     */
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    /**
     * Сравнивает двух сотрудников по идентификатору.
     * Два сотрудника считаются равными, если у них одинаковый ID.
     *
     * @param o объект для сравнения
     * @return true, если сотрудники равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    /**
     * Возвращает хэш-код сотрудника на основе его идентификатора.
     *
     * @return хэш-код сотрудника
     */
    @Override
    public int hashCode() { return Objects.hash(id); }

    /**
     * Возвращает строковое представление сотрудника.
     *
     * @return строка с информацией о сотруднике
     */
    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "', gender='" + gender +
               "', department=" + department + ", salary=" + salary +
               ", birthDate=" + birthDate + "}";
    }
}