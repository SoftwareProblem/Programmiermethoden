import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Token {
    protected Pattern pattern;
    protected Matcher matcher;

    public final Token match(String string){
        return null;
    }
    protected abstract Token getToken();
    protected abstract String getContent();
}
