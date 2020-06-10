package bundesliga.generic2;

/**
 * Klassen-implementierung des ISpieler-Interfaces
 */
public class Spieler implements ISpieler{
    String name;
    int punkte;

    /**
     * Konstruktor der Spieler Klasse
     * @param name des Spielers
     */
    public Spieler(String name){
        this.punkte = 0;
        this.name = name;
    }

    /**
     * Gibt den den Namen des Spielers zurück
     * @return der name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Gibt die Punktzahl des Spielers zurück
     * @return die Punkte
     */
    @Override
    public int getPunkte() {
        return this.punkte;
    }

    /**
     * erhöht die Punkte des Spielers um 1
     */
    @Override
    public void score() {
        this.punkte++;
    }
}
