package ValidateIP;

public class ValidateIP {

    public boolean validate(String ip) {
        String octeto = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
        
        String regex = octeto + "\\." + octeto + "\\." + octeto + "\\." + octeto;

        return ip != null && ip.matches(regex);
    }
}
