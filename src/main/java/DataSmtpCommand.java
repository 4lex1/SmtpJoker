public class DataSmtpCommand  implements SmtpCommand{
    @Override
    public String build() {
        return "DATA";
    }

    @Override
    public void handleResponse(String response) {

    }
}
