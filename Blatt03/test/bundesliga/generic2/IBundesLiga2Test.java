package bundesliga.generic2;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Carsten Gips
 */
public class IBundesLiga2Test {

    /**
     * Korrekte Einschränkung der Typvariablen?
     */
    @Test
    public void test() {
        class Wuppie extends FussballSpieler {

            public Wuppie(String name) {
                super(name);
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

        IBundesLiga2 l = new IBundesLiga2() {

            @Override
            public boolean aufnehmen(IMannschaft<? extends FussballSpieler> mannschaft) {
                return false;
            }

            @Override
            public boolean rauswerfen(IMannschaft<? extends FussballSpieler> mannschaft) {
                return false;
            }

            @Override
            public void sortMannschaften() {
            }

            @Override
            public boolean contains(IMannschaft<? extends FussballSpieler> mannschaft) {
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

        Fluppie f = new Fluppie();
        l.aufnehmen(f);
        l.contains(f);
        l.rauswerfen(f);
        assertNotNull(l);

    }

}
