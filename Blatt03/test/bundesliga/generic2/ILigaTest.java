package bundesliga.generic2;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Carsten Gips
 */
public class ILigaTest {

    /**
     * Sind die richtigen Methoden im Interface vorhanden?
     * Korrekte Einschränkung der Typvariablen?
     */
    @Test
    public void test() {
        class Wuppie implements ISpieler {

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

        }

        class Fluppie implements IMannschaft<Wuppie> {

            @Override
            public boolean aufnehmen(Wuppie spieler) {
                return false;
            }

            @Override
            public boolean rauswerfen(Wuppie spieler) {
                return false;
            }

            @Override
            public boolean auswechseln(Wuppie alt, Wuppie neu) {
                return false;
            }

            @Override
            public int getPunkte() {
                return 0;
            }

            @Override
            public boolean contains(Wuppie spieler) {
                return false;
            }

            @Override
            public int size() {
                return 0;
            }

        }

        ILiga<Fluppie> l = new ILiga<Fluppie>() {

            @Override
            public boolean aufnehmen(Fluppie mannschaft) {
                return false;
            }

            @Override
            public boolean rauswerfen(Fluppie mannschaft) {
                return false;
            }

            @Override
            public void sortMannschaften() {
            }

            @Override
            public boolean contains(Fluppie mannschaft) {
                return false;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Fluppie getFirstTeam() {
                return null;
            }

            @Override
            public Fluppie getLastTeam() {
                return null;
            }
        };

        assertNotNull(l);
    }

}
