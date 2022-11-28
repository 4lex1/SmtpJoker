import com.google.gson.Gson;

import java.io.IOException;

public class Program {
    public static void main(String... args) throws IOException {


        try {
            Group group = new Gson().fromJson(FileUtils.readAllText("C:\\Users\\Alexis\\Desktop\\group.json"), Group.class);
            Mail mail = new Gson().fromJson(FileUtils.readAllText("C:\\Users\\Alexis\\Desktop\\mail.json"), Mail.class);

            SmtpClient client = new SmtpClient("localhost", 25);
            client.sendMail(mail, group);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
