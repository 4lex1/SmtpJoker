package smtp;

import java.util.ArrayList;

public class Group {
    private String from;
    private ArrayList<String> to = new ArrayList<>();

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
}
