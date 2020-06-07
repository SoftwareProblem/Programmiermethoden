package bundesliga.generic2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Carsten Gips
 */
public class SpielerTest {
    private ISpieler s;

    @Before
    public void setUp() {
        s = new Spieler("Werner");
    }

    /**
     * Laesst sich ein Spieler anlegen?
     */
    @Test
    public void testSpieler() {
        assertEquals(s.getName(), "Werner");
        assertEquals(s.getPunkte(), 0);
    }

    /**
     * Funktioniert die Methode <code>Spieler#getName()</code>?
     */
    @Test
    public void testGetName() {
        assertEquals(s.getName(), "Werner");
    }

    /**
     * Funktioniert die Methode <code>Spieler#getPunkte()</code>?
     */
    @Test
    public void testGetPunkte() {
        assertEquals(s.getPunkte(), 0);
    }

    /**
     * Funktioniert die Methode <code>Spieler#score()</code>?
     */
    @Test
    public void testScore() {
        s.score();
        assertEquals(s.getPunkte(), 1);
    }

}
