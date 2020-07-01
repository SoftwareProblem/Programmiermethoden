import java.util.regex.Pattern;

public class NewLine extends Token{
    private String content;

    public NewLine(){
        super.pattern = Pattern.compile("^(\\r\\n|[\\r\\n])");
    }

    @Override
    protected void setContent(String string) {
        this.content = string;
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
