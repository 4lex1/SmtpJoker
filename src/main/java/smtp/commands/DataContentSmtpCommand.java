package smtp.commands;

public class DataContentSmtpCommand implements SmtpCommand{

    private final String subject;
    private final String body;
    private final String from;
    private final String[] to;

    public DataContentSmtpCommand(String subject, String body, String from, String[] to){
        this.subject = subject;
        this.body = body;
        this.from = from;
        this.to = to;
    }

    @Override
    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append("From:").append(from).append("\r\n");
        sb.append("To:");
        for (int i = 0; i < to.length; ++i){
            if (i != 0){
                sb.append(", ");
            }
            sb.append(to[i]);
        }
        sb.append("\r\n");
        sb.append("Subject:").append(subject).append("\r\n\r\n");
        sb.append(body);
        sb.append("\r\n.\r\n");
        return sb.toString();
    }

    @Override
    public void handleResponse(String response) {
        if (!response.equals("250 Ok")){
            throw new RuntimeException("Invalid response from server: " + response);
        }
    }
}
