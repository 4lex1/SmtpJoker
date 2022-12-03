/*
    DAI LABO SMTP
    Authors: Alexis Monthoux, Victor Nondjock
 */

package smtp.commands;

/**
 * Représente une commande SMTP qui peut être envoyée par le client et qui est elle-même responsable de gérer
 * la réponse du serveur.
 */
public interface SmtpCommand {
    String build();
    void handleResponse(String response);
}
