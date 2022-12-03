/*
    DAI LABO SMTP
    Authors: Alexis Monthoux, Victor Nondjock
 */

package smtp.commands;

/**
 * Permet d'envoyer la commande MAIL FROM du dialogue SMTP
 */
public class MailFromSmtpCommand  implements SmtpCommand{

    private final String from;

    public MailFromSmtpCommand(String sender){
        this.from = sender;
    }

    @Override
    public String build() {
        return "MAIL FROM:" + from + "\r\n";
    }

    @Override
    public void handleResponse(String response) {
        if (!response.startsWith("250-")){
            throw new RuntimeException("Invalid response from server: " + response);
        }
    }
}
