package Calendar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ValidateIPTest {

    private final ValidateIP validator = new ValidateIP();

    @Test
    @DisplayName("Deve validar um IP padrão")
    public void testIPPadrao() {
        assertTrue(validator.validate("192.168.0.1"));
    }

    @Test
    @DisplayName("Deve validar os limites (0.0.0.0 e 255.255.255.255)")
    public void testLimitesIP() {
        assertTrue(validator.validate("0.0.0.0"));
        assertTrue(validator.validate("255.255.255.255"));
    }

    @Test
    @DisplayName("Deve rejeitar número maior que 255")
    public void testIPAcimaDoLimite() {
        assertFalse(validator.validate("256.0.0.0"));
    }

    @Test
    @DisplayName("Deve rejeitar IP com blocos a mais ou a menos")
    public void testTamanhoIPInvalido() {
        assertFalse(validator.validate("192.168.0"));
        assertFalse(validator.validate("192.168.0.1.5"));
    }

    @Test
    @DisplayName("Deve rejeitar IPs com caracteres inválidos")
    public void testCaracteresInvalidos() {
        assertFalse(validator.validate("192.168.0.a"));
        assertFalse(validator.validate("192.168..1"));
    }
}
