package CompareSubstrings;

public class CompareSubstrings {

    public String getSmallestAndLargest(String s, int k) {

        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("A string não pode ser nula ou vazia.");
        }

        if (k <= 0) {
            throw new IllegalArgumentException("O valor de k deve ser maior que zero.");
        }

        if (k > s.length()) {
            throw new IllegalArgumentException(
                    "O valor de k (" + k + ") não pode ser maior que o tamanho da string (" + s.length() + ").");
        }

        String substring = s.substring(0, k);
        String smallest = substring;
        String largest = substring;

        for (int i = 1; i <= s.length() - k; i++) {
            substring = s.substring(i, i + k);

            if (substring.compareTo(smallest) < 0) {
                smallest = substring;
            }

            if (substring.compareTo(largest) > 0) {
                largest = substring;
            }
        }

        return smallest + "\n" + largest;
    }
}