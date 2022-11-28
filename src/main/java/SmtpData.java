public class SmtpData implements SmtpCommand{

    private String data;

    public SmtpData(String data){
        this.data = data;
    }

    @Override
    public String build() {
        return data + "\r\n.\r\n";
    }

    @Override
    public void handleResponse(String response) {

    }
}
