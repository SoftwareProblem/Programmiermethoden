package bundesliga.generic2;

/**
 * Abgeleite Klasse von Spieler, die einen Fussballspieler repräsentiert
 */
public class FussballSpieler extends Spieler {
    /**
     * Konstruktor des Fussballspielers
     * @param name der Name des Spielers
     */
    public FussballSpieler(String name) {
        super(name);
    }

    /**
     * Repräsentiert einen Torschuss, erhöht Punktzahl um 1
     */
    public void schiessTor(){
        this.score();
    }
}
