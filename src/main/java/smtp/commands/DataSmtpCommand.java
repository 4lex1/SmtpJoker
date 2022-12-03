package smtp.commands;

public class DataSmtpCommand  implements SmtpCommand{
    @Override
    public String build() {
        return "DATA\r\n";
    }

    @Override
    public void handleResponse(String response) {
        if (!response.equals("250 Ok")){
            throw new RuntimeException("Invalid response from server: " + response);
        }
    }
}
