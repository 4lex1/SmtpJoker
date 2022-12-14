/*
    DAI LABO SMTP
    Authors: Alexis Monthoux, Victor Nondjock
 */

package smtp;

import fun.Joke;
import smtp.commands.*;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Représente un client SMTP capable d'envoyer un mail.
 */
public class SmtpClient {

    private final String host;
    private final int port;

    /**
     * Constructeur
     * @param host Adresse du serveur SMTP
     * @param port Port d'écoute du serveur SMTP
     */
    public SmtpClient(String host, int port){
        this.host = host;
        this.port = port;
    }

    /**
     * Envoyer un mail de blagues 'joke' en utilisant le groupe 'group'.
     * @param joke Blague à utiliser pour formuler le mail.
     * @param group Groupe à utiliser pour déterminer l'émetteur et les récepteurs du mail.
     */
    public void sendMail(Joke joke, Group group){
        ArrayList<SmtpCommand> commands = new ArrayList<>();

        commands.add(new EhloSmtpCommand(group.getFrom()));
        commands.add(new MailFromSmtpCommand(group.getFrom()));
        for (String to : group.getTo()){
            commands.add(new RcptToSmtpCommand(to));
        }
        commands.add(new DataSmtpCommand());
        commands.add(new DataContentSmtpCommand(joke.subject, joke.body, group.getFrom(), group.getTo()));

        try{
            Socket client = new Socket(host, port);

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8));

            String line;
            while ((line = in.readLine()) == null) { }
            System.out.println("S: " + line);

            for (SmtpCommand command : commands){
                String response = sendCommand(command, in, out);
                command.handleResponse(response);
            }
            client.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private String sendCommand(SmtpCommand command, BufferedReader in, BufferedWriter out) throws IOException{
        String message = command.build();
        System.out.print("C: " + message);

        out.write(message);
        out.flush();

        String line;
        while ((line = in.readLine()) == null) { }
        System.out.println("S: " + line);

        return line;
    }
}
