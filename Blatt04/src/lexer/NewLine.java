package lexer;

import lexer.Annotationen.Prio;

import java.util.regex.Pattern;
@Prio(2)
public class NewLine extends Token{
    private String content;

    public NewLine(){
        super.pattern = Pattern.compile("^((\\r\\n)|([\\r\\n])){1}");
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
