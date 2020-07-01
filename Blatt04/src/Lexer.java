import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lexer {
    List<Token> token;
    Token catchAll;
    public Lexer(){
        this.token = new LinkedList<>();
    }
    public void registerToken(Token token){
        this.token.add(token);
    }
    public void registerToken(List<Token> token){
        this.token.addAll(token);
    }
    public void registerCatchAll(Token token){
        this.token.add(token);
    }
    public List<Token> tokenize(String string){
        LinkedList<Token> tokenList = new LinkedList<>();
        // hier weiter machen für die schleife
        //wenn ich nach einem aufruft von testToken den content überprüfe
        // und das dann von string abziehe und beim erneuten aufruf nur den verkürzten nehme sollte es klappen
        while(string.length()!=0) {
            Token test = testTokens(string);
            System.out.println(string);
            if(test!=null) {
                tokenList.add(testTokens(string));
                string = string.replace(tokenList.getLast().getContent(), "");
            } else {
                //System.out.println("Was bedeutet es wenn ich hier lande?!");
            }
        }
        return tokenList;
    }
    private Token testTokens(String string){
        for (Token value : token) {
            Token test = value.match(string);
            if (test != null) {
                return test;
            }
        }
        return null;
    }
}
