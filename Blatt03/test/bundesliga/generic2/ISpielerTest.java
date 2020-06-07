package bundesliga.generic2;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Carsten Gips
 */
public class ISpielerTest {

    /**
     * Sind die richtigen Methoden im Interface vorhanden?
     * Absicherung gegen versehentliches Ändern der Vorgaben ...
     */
    @Test
    public void test() {
        ISpieler s = new ISpieler() {

            @Override
            public String getName() {
                return null;
            }

            @Override
            public int getPunkte() {
                return 0;
            }

            @Override
            public void score() {
            }

        };

        assertNotNull(s);
    }

}
