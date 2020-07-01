import java.util.regex.Pattern;

public class Comment extends Token{
    private String content;

    public Comment(){
        // Regex soll sagen: // mindestens einmal dann egal was bis Zeilenende
        super.pattern = Pattern.compile("//[^\\n\\r]+?(?:\\*\\)|[\\n\\r])");
    }

    @Override
    protected void setContent(String string) {
        this.content = string;
    }

    @Override
    protected Token getToken() {
        return new Comment();
    }

    @Override
    protected String getContent() {
        return this.content;
    }
}
