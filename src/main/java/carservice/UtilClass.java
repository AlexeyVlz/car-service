package carservice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UtilClass {

    public static LocalDate stringToLocalDate(String stringDate) {
        try{
            return LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Некорректный фортмат даты рождения");
        }
    }
    public static String dateToString(LocalDate date) {
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
