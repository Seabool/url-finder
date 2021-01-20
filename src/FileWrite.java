import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URL;

public class FileWrite {
    public void writeToFile(URL url, String head) throws IOException {
        FileWriter fileWriter = new FileWriter("parameters.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        InetAddress address = InetAddress.getByName(url.getHost());

        printWriter.println("Adres IP: " + address.getHostAddress());
        printWriter.println("Adres: " + url.getHost() + url.getPath());
        printWriter.println("Host: " + url.getHost());
        printWriter.println("Port: " + url.getDefaultPort());
        printWriter.println("Protokół: " + url.getProtocol());

        printWriter.println("\nZawartość sekcji <head>: " + head);

        printWriter.close();
    }
}
