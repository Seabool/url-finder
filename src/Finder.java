import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {

    public Set<String> findByRegex(String regex, String text) {

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        Set<String> list = new HashSet<String>();

        while (matcher.find()) {
            list.add(matcher.group());
        }

        return list;
    }

    public Set<String> findLinks(String text) {
        return findByRegex("(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", text);
    }

    public Set<String> findEmails(String text) {
        return findByRegex("\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", text);
    }

    public String findHead(String text) {
        Pattern pattern = Pattern.compile("<head>(.*?)</head>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        Set<String> list = new HashSet<String>();
        String head = "";
        if (matcher.find()) {
            head = matcher.group(1);
        }
        return head;
    }

    public void displayFindings(Set<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
