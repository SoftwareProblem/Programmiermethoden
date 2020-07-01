import java.util.regex.Pattern;

public class NewLine extends Token{
    private String content;

    public NewLine(){
        super.pattern = Pattern.compile("\n");
    }

    @Override
    protected void setContent(String string) {
        this.content = content;
    }

    @Override
    protected Token getToken() {
        return new NewLine();
    }

    @Override
    protected String getContent() {
        return this.content;
    }
}
