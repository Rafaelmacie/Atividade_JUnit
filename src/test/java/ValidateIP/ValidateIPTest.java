package ValidateIP;

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
    @DisplayName("Deve validar 0.0.0.0")
    public void testDownLimitIP() {
        assertTrue(validator.validate("0.0.0.0"));
    }

    @Test
    @DisplayName("Deve validar 255.255.255.255")
    public void testHighLimitIP() {
        assertTrue(validator.validate("255.255.255.255"));
    }

    @Test
    @DisplayName("Deve rejeitar número maior que 255")
    public void testIPAcimaDoLimite() {
        assertFalse(validator.validate("256.0.0.0"));
    }

    @Test
    @DisplayName("Deve rejeitar IP com blocos a menos")
    public void testLowSizeIP() {
        assertFalse(validator.validate("192.168.0"));
    }

    @Test
    @DisplayName("Deve rejeitar IP com blocos a mais")
    public void testHighSizeIP() {
        assertFalse(validator.validate("192.168.0.1.5"));
    }

    @Test
    @DisplayName("Deve rejeitar IPs com caracteres inválidos")
    public void testCaracteresInvalidos() {
        assertFalse(validator.validate("192.168.0.a"));
    }

    @Test
    @DisplayName("Deve rejeitar IP com bloco vazio")
    public void testNullFieldIP() {
        assertFalse(validator.validate("192.168..1"));
    }

    @Test
    @DisplayName("Deve rejeitar valor nulo")
    public void testNull() {
        assertFalse(validator.validate(null));
    }

    @Test
    @DisplayName("Deve rejeitar IP sem pontos")
    public void testDotsIP(){
        assertFalse(validator.validate("19216810196"));
    }
}
