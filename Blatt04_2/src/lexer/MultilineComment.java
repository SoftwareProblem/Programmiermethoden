package lexer;

import java.util.regex.Pattern;

public class MultilineComment extends Token{
    private String content;

    public MultilineComment(){
        super.pattern = Pattern.compile("^(/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/)");
    }
    @Override
    protected void setContent(String string) {
        this.content = string;
    }

    @Override
    protected Token getToken() {
        return new MultilineComment();
    }

    @Override
    protected String getContent() {
        return this.content;
    }
}
