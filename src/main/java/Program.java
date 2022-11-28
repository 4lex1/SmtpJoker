public class Program {
    public static void main(String ... args){
        SmtpClient client = new SmtpClient();

        Group group = new Group();
        group.setFrom("alexis.monthoux@bluewin.ch");
        group.setTo("victor.nondjock@evolink.ch", "abraham.rubinstein@heig-vd.ch");

        Mail mail = new Mail();
        mail.setSubject("Test mail");
        mail.setBody("Ceci est un mail de test hyper rigolo");

        client.sendMail(mail, group);
    }
}
