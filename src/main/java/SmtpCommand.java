public interface SmtpCommand {
    String build();
    void handleResponse(String response);
}
