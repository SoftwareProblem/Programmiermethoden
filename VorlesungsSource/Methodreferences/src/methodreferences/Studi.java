package methodreferences;

/**
 * @author Carsten Gips
 */

public class Studi {
    private final String name;
    private final int credits;

    public Studi(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int compareCredits(Studi o) {
        return o.getCredits() - this.getCredits();
    }

    @Override
    public String toString() {
        return getName() + " (" + getCredits() + ")";
    }

}
