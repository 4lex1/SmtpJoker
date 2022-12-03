package smtp.commands;

public class EhloSmtpCommand implements SmtpCommand{

    private String identity;

    public EhloSmtpCommand(String identity){
        this.identity = identity;
    }

    @Override
    public String build() {
        return "EHLO " + identity + "\r\n";
    }

    @Override
    public void handleResponse(String response) {
        if (!response.startsWith("250-")){
            throw new RuntimeException("Invalid response from server: " + response);
        }
    }
}
