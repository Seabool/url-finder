import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Document {

    public String getDocument(URL url) throws IOException {

        Scanner scanner = new Scanner(url.openStream());
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }

        return builder.toString();
    }
}