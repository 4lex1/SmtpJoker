import java.util.ArrayList;

public class SmtpClient {
    public void sendMail(Mail mail, Group group){
        ArrayList<SmtpCommand> commands = new ArrayList<>();

        commands.add(new EhloSmtpCommand(group.getFrom()));
        commands.add(new MailFromSmtpCommand(group.getFrom()));
        for (String to : group.getTo()){
            commands.add(new RcptToSmtpCommand(to));
        }
        commands.add(new DataSmtpCommand());
        commands.add(new SmtpData(mail.getBody()));

        for (SmtpCommand command : commands){
            String response = sendCommand(command);
            command.handleResponse(response);
        }
    }

    private String sendCommand(SmtpCommand command){
        System.out.println(command.build());
        return "command response";
    }
}
