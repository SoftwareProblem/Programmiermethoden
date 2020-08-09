package defaultmethods;

/**
 * @author Carsten Gips
 */

interface A {
    default void hello() {
        System.out.println("A");
    }
}

interface B extends A {
    @Override
    default void hello() {
        System.out.println("B");
    }
}

interface C {
    default void hello() {
        System.out.println("C");
    }
}

class D implements A, B {
}

class E implements A {
    @Override
    public void hello() {
        System.out.println("E");
    }
}

class F extends E implements A {
}

class G implements A, C {
    @Override
    public void hello() {
        A.super.hello();
    }
}

class H extends E implements B, A {
}

public class DefaultTest {
    public static void main(String... args) {
        new F().hello();  // ??? (Regel 1)
        new D().hello();  // ??? (Regel 2)
        new G().hello();  // ??? (Regel 3)
        new H().hello();  // ???
    }
}
