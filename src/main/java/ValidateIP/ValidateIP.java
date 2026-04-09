package ValidateIP;

public class ValidateIP {

    public boolean validate(String ip) {
        // Regex para validar um octeto de 0 a 255:
        // 1. [0-9]           -> Números de 1 dígito (0-9)
        // 2. [1-9][0-9]      -> Números de 2 dígitos (10-99)
        // 3. 1[0-9][0-9]     -> Números de 100 a 199
        // 4. 2[0-4][0-9]     -> Números de 200 a 249
        // 5. 25[0-5]         -> Números de 250 a 255
        String octeto = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
        
        // A estrutura completa: octeto.octeto.octeto.octeto
        String regex = octeto + "\\." + octeto + "\\." + octeto + "\\." + octeto;

        return ip != null && ip.matches(regex);
    }
}
