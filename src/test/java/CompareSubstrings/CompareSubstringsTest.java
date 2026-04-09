package CompareSubstrings;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class CompareSubstringsTest {

    private final CompareSubstrings cs = new CompareSubstrings();

    @Test
    @DisplayName("Deve retornar a menor e maior substring do exemplo (welcometojava, 3)")
    public void testExemploEnunciado() {
        String resultadoEsperado = "ava" + "\n" + "wel";
        assertEquals(resultadoEsperado, cs.getSmallestAndLargest("welcometojava", 3));
    }

    @Test
    @DisplayName("Deve funcionar com k igual ao tamanho total da string")
    public void testTamanhoKIgualString() {
        String s = "java";
        String resultadoEsperado = "java" + "\n" + "java";
        assertEquals(resultadoEsperado, cs.getSmallestAndLargest(s, 4));
    }

    @Test
    @DisplayName("Deve diferenciar maiúsculas de minúsculas (Ordem ASCII)")
    public void testDiferencaCase() {
        // Na tabela ASCII, letras maiúsculas vem antes de minúsculas
        String s = "AaBC";
        String resultadoEsperado = "A" + "\n" + "a";
        assertEquals(resultadoEsperado, cs.getSmallestAndLargest(s, 1));
    }
}
