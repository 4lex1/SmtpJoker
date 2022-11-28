public class DataSmtpCommand  implements SmtpCommand{
    @Override
    public String build() {
        return "DATA\r\n";
    }

    @Override
    public void handleResponse(String response) {
    }
}
