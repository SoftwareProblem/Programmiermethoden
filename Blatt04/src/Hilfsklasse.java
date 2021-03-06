import lexer.*;
import java.util.*;

public class Hilfsklasse {
    public static void main(String[] args) {
        String testString = """
                // test test void
                "test213"/* test2 */
                                
                                
                /* test123 public


                test231 */
                "test2132"
                public void private protected this
                // test test void""";
        Lexer test = new Lexer();

        List<Token> testList = new LinkedList<>();
        testList.add(new Comment());
        testList.add(new MultilineComment());
        testList.add(new StringContent());
        testList.add(new KeyWord());
        testList.add(new NewLine());
        test.registerToken(testList);
        test.registerCatchAll(new lexer.CatchAll());

        List<Token> list = new LinkedList<>();
        list = test.tokenize(testString);
    }
}
