import javax.print.attribute.standard.PresentationDirection;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
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

        commands.add(new EhloSmtpCommand(group.from));
        commands.add(new MailFromSmtpCommand(group.from));
        for (String to : group.to){
            commands.add(new RcptToSmtpCommand(to));
        }
        commands.add(new DataSmtpCommand());
        commands.add(new SmtpData(mail.subject, mail.body, group.from, group.to));

        Socket client = null;
        BufferedReader in = null;
        BufferedWriter out = null;

        try{
            client = new Socket(host, port);

            in = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8));

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
