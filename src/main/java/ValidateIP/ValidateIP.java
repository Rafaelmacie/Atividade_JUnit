package ValidateIP;

public class ValidateIP {

    public boolean validate(String ip) {
        if (ip == null || ip.trim().isEmpty()) {
            throw new IllegalArgumentException("O IP não pode ser nulo ou vazio.");
        }

        String octeto = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";

        String regex = octeto + "\\." + octeto + "\\." + octeto + "\\." + octeto;

        return ip != null && ip.matches(regex);
    }
}
