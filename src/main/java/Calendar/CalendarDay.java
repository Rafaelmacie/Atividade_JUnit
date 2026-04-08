package Calendar;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalendarDay {

    public String findDay(int day, int month, int year) {
        validateDate(day, month, year);

        // API usada para encontrar o dia da semana
        LocalDate date = LocalDate.of(year, month, day);

        // Retorna o dia da semana em português (ex: SEGUNDA-FEIRA)
        return date.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pt-BR"))
                .toUpperCase();
    }

    // Método de validação
    private void validateDate(int day, int month, int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("O ano deve ser maior que 0!");
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Os meses devem estar entre 1 e 12!");
        }

        int maxDays;
        switch (month) {
            case 2:
                maxDays = isLeapYear(year) ? 29 : 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxDays = 30;
                break;
            default:
                maxDays = 31;
        }

        if (day < 1 || day > maxDays) {
            String msg = (month == 2 && !isLeapYear(year))
                    ? "Fevereiro só tem 28 dias em anos não bissextos."
                    : "Dia inválido para o mês informado.";
            throw new IllegalArgumentException(msg);
        }
    }

    // Lógica para verificar se o ano é bissexto
    private boolean isLeapYear(int year) {
        // Regra: divisível por 4, mas não por 100, exceto se for divisível por 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
