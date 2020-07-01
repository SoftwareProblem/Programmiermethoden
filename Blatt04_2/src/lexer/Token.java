package lexer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Token {
    protected Pattern pattern;
    protected Matcher matcher;

    public final Token match(String string){
        pattern = getToken().pattern;
        matcher = pattern.matcher(string);

        if(matcher.find()) {
            Token token = getToken();
            System.out.println(token.getClass());
            token.setContent(string.substring(matcher.start(),matcher.end()));
            return token;
        }else {
            return null;
        }
    }
    protected abstract void setContent(String string);
    protected abstract Token getToken();
    protected abstract String getContent();
}
