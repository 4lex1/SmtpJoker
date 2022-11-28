import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Group {
    private String from;
    private String[] to;

    public String getFrom(){
        return from;
    }

    public void setFrom(String from){
        this.from = from;
    }

    public String[] getTo(){
        return to;
    }

    public void setTo(String ... to){
        this.to = to;
    }

    public static Group fromFile(String path) throws ParseException {
        JSONParser parser = new JSONParser();
        return (Group)parser.parse(path);
    }
}
