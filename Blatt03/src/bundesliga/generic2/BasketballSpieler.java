package bundesliga.generic2;

/**
 * Abgeleite Klasse von Spieler, die einen Basketballspieler repräsentiert
 */
public class BasketballSpieler extends Spieler{
    /**
     * Konstruktor des Basketballspielers
     * @param name des Spielers
     */
    public BasketballSpieler(String name) {
        super(name);
    }

    /**
     * repräsentiert einen Korbwurf, erhöht Punktzahl um 2
     */
    public void wirfKorb(){
        this.score();
        this.score();
    }
}
