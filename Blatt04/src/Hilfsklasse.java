import java.util.LinkedList;
import java.util.List;

public class Hilfsklasse {
    public static void main(String[] args){
        String testString = "// test test \n\"test213\"/* test2 */\n/* test123 \n test231 */ \n \n \"test213\"";
        Lexer test = new Lexer();
        List<Token> testList = new LinkedList<>();
        testList.add(new Comment());
        testList.add(new MultilineComment());
        testList.add(new StringContent());
       // testList.add(new KeyWord());
        testList.add(new NewLine());
        test.registerToken(testList);
        test.registerCatchAll(new CatchAll());
        List<Token> list = new LinkedList<>();
        list = test.tokenize(testString);
        for(Token Value : list){
            System.out.println(Value.getContent());
        }

    }
}
