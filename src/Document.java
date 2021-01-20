import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Document {

    public String getDocument(URL url) throws IOException {

        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();

        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }

        return sb.toString();
    }

}