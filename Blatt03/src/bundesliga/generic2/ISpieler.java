package bundesliga.generic2;

/**
 * @author Carsten Gips
 */
public interface ISpieler {
    /**
     * Liefert den Namen des Spielers zurück.
     *
     * @return Name des Spielers
     */
    String getName();

    /**
     * Liefert die vom Spieler erzielten Punkte zurück.
     *
     * @return Punkte des Spielers
     */
    int getPunkte();

    /**
     * Erzielt einen Punkt.
     * <p>
     * Wird von passenden Methoden in den implementierenden Klassen aufgerufen:
     * <ul>
     * <li>Ein Fussballspieler erzielt einen Punkt, indem er ein Tor schiesst
     * (mit {@link FussballSpieler#schiessTor()}).
     * <li>Ein Basketballspieler erzielt zwei Punkte, indem er einen Korb wirft
     * (mit {@link BasketballSpieler#wirfKorb()}).
     * </ul>
     */
    void score();

}
