import java.util.regex.Pattern;

public class KeyWord extends Token{
    private String content;

    // Muss ich hier im regex mehrere oders packen oder doch für jedes Keyword eine Klasse?
    public KeyWord(){
        super.pattern = Pattern.compile("");
    }
    @Override
    protected void setContent(String string) {
        this.content = string;
    }

    @Override
    protected Token getToken() {
        return new KeyWord();
    }

    @Override
    protected String getContent() {
        return this.content;
    }
}
