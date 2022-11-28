public class SmtpData implements SmtpCommand{

    private String subject;
    private String body;
    private String from;
    private String[] to;

    public SmtpData(String subject, String body, String from, String[] to){
        this.subject = subject;
        this.body = body;
        this.from = from;
        this.to = to;
    }

    @Override
    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append("From: <").append(from).append(">\r\n");
        sb.append("To: ");
        for (int i = 0; i < to.length; ++i){
            if (i != 0){
                sb.append(", ");
            }
            sb.append("<").append(to[i]).append(">");
        }
        sb.append("\r\n");
        sb.append("Subject: ").append(subject).append("\r\n\r\n");
        sb.append(body);
        sb.append("\r\n.\r\n");
        return sb.toString();
    }

    @Override
    public void handleResponse(String response) {
    }
}
