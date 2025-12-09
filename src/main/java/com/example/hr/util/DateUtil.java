package com.example.hr.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Утилитарный класс для работы с датами.
 * Поддерживает парсинг дат из различных строковых форматов.
 */
public class DateUtil {

    /** Массив поддерживаемых форматов дат */
    private static final String[] DATE_FORMATS = {
        "dd.MM.yyyy", "dd/MM/yyyy", "yyyy-MM-dd", "dd-MM-yyyy",
        "MM/dd/yyyy", "yyyy/MM/dd"
    };

    /**
     * Парсит строку с датой в объект LocalDate.
     * Пытается применить различные форматы дат по порядку.
     *
     * @param dateString строка с датой для парсинга
     * @return объект LocalDate или null, если строка пуста или null
     * @throws IllegalArgumentException если ни один формат не подошел
     */
    public static LocalDate parseDate(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return null;
        }

        for (String format : DATE_FORMATS) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                return LocalDate.parse(dateString.trim(), formatter);
            } catch (DateTimeParseException ignored) {
                // Продолжаем пробовать следующий формат
            }
        }

        throw new IllegalArgumentException("Cannot parse date: " + dateString);
    }
}