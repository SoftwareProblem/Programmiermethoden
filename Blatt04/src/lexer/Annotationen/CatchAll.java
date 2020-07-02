package lexer.Annotationen;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CatchAll {
    int value() default 4;
}
