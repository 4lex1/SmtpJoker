import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class SmtpClient {

    private String host;
    private int port;

    public SmtpClient(String host, int port){
        this.host = host;
        this.port = port;
    }

    public void sendMail(Mail mail, Group group){
        ArrayList<SmtpCommand> commands = new ArrayList<>();

        commands.add(new EhloSmtpCommand(group.getFrom()));
        commands.add(new MailFromSmtpCommand(group.getFrom()));
        for (String to : group.getTo()){
            commands.add(new RcptToSmtpCommand(to));
        }
        commands.add(new DataSmtpCommand());
        commands.add(new SmtpData(mail.getBody()));

        try{
            Socket client = new Socket();
            // Ouvrir la connexion avec le serveur
            for (SmtpCommand command : commands){
                String response = sendCommand(client, command);
                command.handleResponse(response);
            }
            client.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private String sendCommand(Socket client, SmtpCommand command){
        String message = command.build();
        // Envoyer message au serveur encodé en UTF-8
        // Flush
        // Retourner la réponse du serveur en String
        return "command response";
    }
}
