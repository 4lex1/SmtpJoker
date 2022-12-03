/*
    DAI LABO SMTP
    Authors: Alexis Monthoux, Victor Nondjock
 */

package smtp;

import java.util.ArrayList;

/**
 * Représente une groupe de victimes et permet de renseigner les champs 'from' et 'to' d'un mail via
 * le protocole SMTP.
 */
public class Group {
    private String from;
    private final ArrayList<String> to = new ArrayList<>();

    public String getFrom(){
        return from;
    }

    public void setFrom(String value){
        from = value;
    }

    public String[] getTo(){
        return to.toArray(new String[0]);
    }

    public void addTo(String value){
        to.add(value);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("From: ").append(from).append("\n");
        sb.append("To: ");
        for (int i = 0; i < to.size(); ++i){
            if (i != 0){
                sb.append(", ");
            }
            sb.append(to.get(i));
        }
        sb.append("\n");

        return sb.toString();
    }
}
