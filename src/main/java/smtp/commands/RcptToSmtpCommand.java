/*
    DAI LABO SMTP
    Authors: Alexis Monthoux, Victor Nondjock
 */

package smtp.commands;

/**
 * Permet d'envoyer la commander RCPT TO du dialogue SMTP.
 */
public class RcptToSmtpCommand  implements SmtpCommand{
    private String to;

    public RcptToSmtpCommand(String to){
        this.to = to;
    }

    @Override
    public String build() {
        return "RCPT TO:" + to + "\r\n";
    }

    @Override
    public void handleResponse(String response) {
        if (!response.equals("250 Ok")){
            throw new RuntimeException("Invalid response from server: " + response);
        }
    }
}
