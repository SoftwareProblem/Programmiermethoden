import java.util.regex.Pattern;

public class CatchAll extends Token{
    private String content;


    public CatchAll(){
        super.pattern = Pattern.compile("^.",Pattern.DOTALL);
    }

    @Override
    protected void setContent(String string) {
        this.content = string;
    }

    @Override
    protected Token getToken() {
        return new CatchAll();
    }

    @Override
    protected String getContent() {
        return this.content;
    }
}
