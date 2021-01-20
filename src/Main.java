import java.io.IOException;
import java.net.URL;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        try {
            URL url = new URL(args[0]);

            Document html = new Document();
            Finder finder = new Finder();

            String content = html.getDocument(url);

            String head = finder.findHead(content);

            FileWrite fileWrite = new FileWrite();
            fileWrite.writeToFile(url, head);

            Set<String> links = finder.findLinks(content);
            Set<String> emails = finder.findEmails(content);

            System.out.println("Links: ");
            finder.displayFindings(links);

            System.out.println("Emails: ");
            finder.displayFindings(emails);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
