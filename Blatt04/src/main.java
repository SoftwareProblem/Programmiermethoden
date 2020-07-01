import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Später löschen ist nur fürs testen von Regex kack
 */
public class main {
    public static void main(String[] args){
        String test = "'// dasddhjbasdkdd '";
        Pattern p = Pattern.compile("'(//){1}.*'");
        Matcher m = p.matcher(test);
        System.out.println(m.matches());
    }
}
