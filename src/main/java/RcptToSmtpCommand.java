public class RcptToSmtpCommand  implements SmtpCommand{
    private String to;

    public RcptToSmtpCommand(String to){
        this.to = to;
    }

    @Override
    public String build() {
        return "RCPT TO: <" + to + ">";
    }

    @Override
    public void handleResponse(String response) {

    }
}
