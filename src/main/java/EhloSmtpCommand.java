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
    }
}
