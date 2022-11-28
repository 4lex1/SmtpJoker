public class MailFromSmtpCommand  implements SmtpCommand{

    private final String from;

    public MailFromSmtpCommand(String sender){
        this.from = sender;
    }

    @Override
    public String build() {
        return "MAIL FROM: <" + from + ">";
    }

    @Override
    public void handleResponse(String response) {

    }
}
