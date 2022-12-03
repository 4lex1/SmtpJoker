import com.google.gson.Gson;
import fun.Configuration;
import smtp.Group;
import smtp.SmtpClient;

public class Program {
    public static void main(String... args) {
        if (args.length != 1) {
            throw new RuntimeException("Invalid arguments. Usage: SmtpJoker <number_of_groups>");
        }

        try {
            int groupCount = Integer.parseInt(args[0]);

            if (groupCount < 1) {
                throw new RuntimeException("Invalid value for <number_of_groups>. Should be a positive number");
            }

            Configuration config = new Gson().fromJson(FileUtils.readAllText("config.json"), Configuration.class);
            Group[] groups = config.createGroups(groupCount);

            SmtpClient client = new SmtpClient("localhost", 25);
            for (Group group : groups){
                client.sendMail(config.getRandomJoke(), group);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
