/*
    DAI LABO SMTP
    Authors: Alexis Monthoux, Victor Nondjock
 */

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

            System.out.println("Reading configuration file...");
            Configuration config = new Gson().fromJson(FileUtils.readAllText("config.json"), Configuration.class);

            System.out.println("Creating groups...");
            Group[] groups = config.createGroups(groupCount);

            for (int i = 0; i < groups.length; ++i){
                System.out.println("Group " + (i + 1));
                System.out.println(groups[i]);
            }
            System.out.println("============================");

            SmtpClient client = new SmtpClient("localhost", 25);
            for (Group group : groups){
                client.sendMail(config.getRandomJoke(), group);
                System.out.println("============================");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
