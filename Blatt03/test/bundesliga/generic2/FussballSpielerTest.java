package bundesliga.generic2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Steven Yeates
 * @author Carsten Gips
 */
public class FussballSpielerTest {
    private FussballSpieler s;

    @Before
    public void setUp() {
        s = new FussballSpieler("Klaus Klausedahl");
    }

    /**
     * Laesst sich ein FussballSpieler anlegen?
     */
    @Test
    public void testFussballSpieler() {
        assertNotNull(s);
    }

    /**
     * Funktioniert die Methode <code>FussballSpieler#getName()</code>?
     */
    @Test
    public void testGetName() {
        assertEquals(s.getName(), "Klaus Klausedahl");
    }

    /**
     * Funktioniert die Methode <code>FussballSpieler#getPunkte()</code>?
     */
    @Test
    public void testGetPunkte() {
        assertEquals(s.getPunkte(), 0);
    }

    /**
     * Funktioniert das Tore-schiessen mit
     * <code>FussballSpieler#schiessTor()</code>?
     */
    @Test
    public void testSchiessTor() {
        int soll = s.getPunkte() + 1;
        s.schiessTor();
        assertEquals(s.getPunkte(), soll);
    }

    /**
     * Passt <code>FussballSpieler#score()</code>?
     */
    @Test
    public void testScore() {
        int soll = s.getPunkte() + 1;
        s.score();
        assertEquals(s.getPunkte(), soll);
    }

}
