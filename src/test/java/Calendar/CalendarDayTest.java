package Calendar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class CalendarDayTest {

    private final CalendarDay cd = new CalendarDay();

    // --- TESTES DE MESES COM 31 DIAS ---

    @Test
    @DisplayName("Deve aceitar o dia 31 em Janeiro")
    public void testDia31JaneiroValido() {
        assertEquals("QUARTA-FEIRA", cd.findDay(31, 1, 2024));
    }

    @Test
    @DisplayName("Deve rejeitar o dia 32 em Janeiro")
    public void testDia32JaneiroInvalido() {
        assertThrows(IllegalArgumentException.class, () -> cd.findDay(32, 1, 2024));
    }

    // --- TESTES DE MESES COM 30 DIAS ---

    @Test
    @DisplayName("Deve aceitar o dia 30 em Abril")
    public void testDia30AbrilValido() {
        assertEquals("TERÇA-FEIRA", cd.findDay(30, 4, 2024));
    }

    @Test
    @DisplayName("Deve rejeitar o dia 31 em Abril")
    public void testDia31AbrilInvalido() {
        assertThrows(IllegalArgumentException.class, () -> cd.findDay(31, 4, 2024));
    }

    // --- TESTES DE FEVEREIRO (BISSEXTO) ---

    @Test
    @DisplayName("Deve aceitar 29 de Fevereiro em ano bissexto")
    public void testFevereiroBissextoValido() {
        assertEquals("QUINTA-FEIRA", cd.findDay(29, 2, 2024));
    }

    @Test
    @DisplayName("Deve rejeitar 29 de Fevereiro em ano comum")
    public void testFevereiroComumInvalido() {
        assertThrows(IllegalArgumentException.class, () -> cd.findDay(29, 2, 2023));
    }

    // --- TESTES DE VALIDAÇÃO DE MÊS ---

    @Test
    @DisplayName("Deve rejeitar mês menor que 1")
    public void testMesMenorQueUm() {
        assertThrows(IllegalArgumentException.class, () -> cd.findDay(1, 0, 2024));
    }

    @Test
    @DisplayName("Deve rejeitar mês maior que 12")
    public void testMesMaiorQueDoze() {
        assertThrows(IllegalArgumentException.class, () -> cd.findDay(1, 13, 2024));
    }

    // --- TESTES DE VALIDAÇÃO DE ANO ---

    @Test
    @DisplayName("Deve rejeitar ano igual a zero")
    public void testAnoZeroInvalido() {
        assertThrows(IllegalArgumentException.class, () -> cd.findDay(1, 1, 0));
    }

    @Test
    @DisplayName("Deve rejeitar ano negativo")
    public void testAnoNegativoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> cd.findDay(1, 1, -2024));
    }
}