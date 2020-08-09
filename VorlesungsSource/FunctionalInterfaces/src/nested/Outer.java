package nested;

/**
 * @author Carsten Gips
 * <p>
 * Nur als Vorlage für die Folien ...
 */

public class Outer {
    public static void main(String[] args) {
        Outer.Inner nested = new Outer().new Inner();
    }

    private class Inner {
    }
}
