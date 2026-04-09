package CompareSubstrings;

public class CompareSubstrings {
    public String getSmallestAndLargest(String s, int k) {
        // Inicializamos a menor e a maior com a primeira substring possível
        String substring = s.substring(0, k);
        String smallest = substring;
        String largest = substring;

        // Percorremos a string original
        // O limite é s.length() - k para não estourar o índice no final
        for (int i = 1; i <= s.length() - k; i++) {
            substring = s.substring(i, i + k);

            // Se a substring atual for menor que a 'smallest', ela assume o lugar
            if (substring.compareTo(smallest) < 0) {
                smallest = substring;
            }

            // Se a substring atual for maior que a 'largest', ela assume o lugar
            if (substring.compareTo(largest) > 0) {
                largest = substring;
            }
        }

        return smallest + "\n" + largest;
    }
}
