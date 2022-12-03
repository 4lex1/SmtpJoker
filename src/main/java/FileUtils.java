/*
    DAI LABO SMTP
    Authors: Alexis Monthoux, Victor Nondjock
 */

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Classe utilitaire de manipulation de fichiers IO.
 */
public class FileUtils {

    /**
     * Lis le fichier au chemin 'path' et retourne son contenu sous forme de String.
     * @param path Chemin d'accès au fichier à lire.
     * @return Contenu du fichier sous forme de String.
     * @throws IOException En cas d'erreur lors de la lecture du fichier.
     */
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
