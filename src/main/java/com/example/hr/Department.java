package com.example.hr;

import java.util.Objects;

/**
 * Класс, представляющий подразделение компании.
 * Автоматически генерирует уникальные идентификаторы при создании.
 */
public class Department {
    /** Счетчик для генерации уникальных идентификаторов подразделений */
    private static int nextId = 1;

    private int id;
    private String name;

    /**
     * Конструктор по умолчанию для создания подразделения.
     * Автоматически генерирует уникальный идентификатор.
     */
    public Department() { this.id = nextId++; }

    /**
     * Конструктор для создания подразделения с указанным именем.
     *
     * @param name название подразделения
     */
    public Department(String name) {
        this();
        this.name = name;
    }

    /**
     * Возвращает уникальный идентификатор подразделения.
     *
     * @return идентификатор подразделения
     */
    public int getId() { return id; }

    /**
     * Устанавливает идентификатор подразделения.
     * Используется с осторожностью, чтобы не нарушить уникальность.
     *
     * @param id новый идентификатор подразделения
     */
    public void setId(int id) { this.id = id; }

    /**
     * Возвращает название подразделения.
     *
     * @return название подразделения
     */
    public String getName() { return name; }

    /**
     * Устанавливает название подразделения.
     *
     * @param name новое название подразделения
     */
    public void setName(String name) { this.name = name; }

    /**
     * Сравнивает два подразделения по идентификатору.
     * Два подразделения считаются равными, если у них одинаковый ID.
     *
     * @param o объект для сравнения
     * @return true, если подразделения равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id;
    }

    /**
     * Возвращает хэш-код подразделения на основе его идентификатора.
     *
     * @return хэш-код подразделения
     */
    @Override
    public int hashCode() { return Objects.hash(id); }

    /**
     * Возвращает строковое представление подразделения.
     *
     * @return строка с информацией о подразделении
     */
    @Override
    public String toString() {
        return "Department{id=" + id + ", name='" + name + "'}";
    }
}