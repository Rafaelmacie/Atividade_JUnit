package CompareSubstrings;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class CompareSubstringsTest {

    private final CompareSubstrings cs = new CompareSubstrings();

    @Test
    @DisplayName("Deve retornar a menor e maior substring")
    public void testExemploEnunciado() {
        String resultadoEsperado = "ava" + "\n" + "wel";
        assertEquals(resultadoEsperado, cs.getSmallestAndLargest("welcometojava", 3));
    }

    @Test
    @DisplayName("Deve funcionar com k igual ao tamanho total da string")
    public void testTamanhoKIgualString() {
        String resultadoEsperado = "java" + "\n" + "java";
        assertEquals(resultadoEsperado, cs.getSmallestAndLargest("java", 4));
    }

    @Test
    @DisplayName("Deve lançar exceção se k for maior que o tamanho da string")
    public void testKMaiorQueString() {
        assertThrows(IllegalArgumentException.class, () -> cs.getSmallestAndLargest("java", 5));
    }

    @Test
    @DisplayName("Deve diferenciar maiúsculas de minúsculas (Ordem ASCII)")
    public void testDiferencaCase() {
        String resultadoEsperado = "A" + "\n" + "a";
        assertEquals(resultadoEsperado, cs.getSmallestAndLargest("AaBC", 1));
    }

    @Test
    @DisplayName("Deve lançar exceção se a string for nula")
    public void testStringNula() {
        assertThrows(IllegalArgumentException.class, () -> cs.getSmallestAndLargest(null, 3));
    }

    @Test
    @DisplayName("Deve lançar exceção se a string for vazia")
    public void testStringVazia() {
        assertThrows(IllegalArgumentException.class, () -> cs.getSmallestAndLargest("", 3));
    }

    @Test
    @DisplayName("Deve lançar exceção se k for zero")
    public void testKZero() {
        assertThrows(IllegalArgumentException.class, () -> cs.getSmallestAndLargest("java", 0));
    }

    @Test
    @DisplayName("Deve lançar exceção se k for negativo")
    public void testKNegativo() {
        assertThrows(IllegalArgumentException.class, () -> cs.getSmallestAndLargest("java", -2));
    }

}