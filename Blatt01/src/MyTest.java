import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyTest {
    int timeout() default 100;
}
class main{
    @MyTest
    public void test(){

    }
    @MyTest(timeout = 200)
    public void test2(){

    }
}