import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtils {
    public static String readAllText(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null){
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
