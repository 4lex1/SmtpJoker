/*
    DAI LABO SMTP
    Authors: Alexis Monthoux, Victor Nondjock
 */

package smtp.commands;

/**
 * Permet d'envoyer la commande DATA du dialogue SMTP.
 */
public class DataSmtpCommand  implements SmtpCommand{
    @Override
    public String build() {
        return "DATA\r\n";
    }

    @Override
    public void handleResponse(String response) {
        if (!response.equals("250 Ok")){
            throw new RuntimeException("Invalid response from server: " + response);
        }
    }
}
