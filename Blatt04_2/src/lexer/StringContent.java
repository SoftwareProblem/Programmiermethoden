package lexer;

import java.util.regex.Pattern;

public class StringContent extends Token {
    private String content;

    public StringContent(){
        super.pattern = Pattern.compile("^(\"[^*]*\"){1}");
    }

    @Override
    protected void setContent(String string) {
        this.content = string;
    }

    @Override
    protected Token getToken() {
        return new StringContent();
    }

    @Override
    protected String getContent() {
        return this.content;
    }
}
