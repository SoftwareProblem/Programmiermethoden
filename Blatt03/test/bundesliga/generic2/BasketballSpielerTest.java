package bundesliga.generic2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Steven Yeates
 * @author Carsten Gips
 */
public class BasketballSpielerTest {
    private BasketballSpieler s;

    @Before
    public void setUp() {
        s = new BasketballSpieler("Klaus Klausedahl");
    }

    /**
     * Laesst sich ein BasketballSpieler anlegen?
     */
    @Test
    public void testBasketballSpieler() {
        assertNotNull(s);
    }

    /**
     * Funktioniert die Methode <code>BasketballSpieler#getName()</code>?
     */
    @Test
    public void testGetName() {
        assertEquals(s.getName(), "Klaus Klausedahl");
    }

    /**
     * Funktioniert die Methode <code>BasketballSpieler#getPunkte()</code>?
     */
    @Test
    public void testGetPunkte() {
        assertEquals(s.getPunkte(), 0);
    }

    /**
     * Test method for {@link BasketballSpieler#wirfKorb()}
     * <p>
     * Funktioniert das Korbwerfen mit
     * <code>BasketballSpieler#wirfKorb()</code>?
     */
    @Test
    public void testWirfKorb() {
        int soll = s.getPunkte() + 2;
        s.wirfKorb();
        assertEquals(s.getPunkte(), soll);
    }

    /**
     * Passt <code>BasketballSpieler#score()</code>?
     */
    @Test
    public void testScore() {
        int soll = s.getPunkte() + 1;
        s.score();
        assertEquals(s.getPunkte(), soll);
    }

}
