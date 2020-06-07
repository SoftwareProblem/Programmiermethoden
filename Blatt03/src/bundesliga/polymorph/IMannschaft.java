package bundesliga.polymorph;

import bundesliga.generic2.ISpieler;

/**
 * @author Carsten Gips
 */
public interface IMannschaft {
    /**
     * Nimmt einen Spieler in die Mannschaft auf.
     * <p>
     * Ein Spieler kann in mehreren verschiedenen Mannschaften spielen, aber in
     * einer Mannschaft nur einmal gelistet sein.
     * <p>
     * Es gibt <b>keine</b> Reihenfolge unter den Spielern einer Mannschaft.
     *
     * @param spieler Spieler, der aufgenommen werden soll.
     * @return <code>false</code> wenn Spieler nicht hinzugefügt werden konnte,
     * sonst <code>true</code>.
     */
    boolean aufnehmen(ISpieler spieler);

    /**
     * Entfernt einen Spieler aus der Mannschaft.
     *
     * @param spieler Spieler, der entfernt werden soll.
     * @return <code>false</code> wenn Spieler nicht entfernt werden konnte,
     * ansonsten <code>true</code>.
     */
    boolean rauswerfen(ISpieler spieler);

    /**
     * Wechselt zwei Spieler aus.
     * <p>
     * Der Spieler <code>alt</code> wird aus der Mannschaft geworfen, und der
     * Spieler <code>neu</code> wird in die Mannschaft aufgenommen. Das geht
     * nur, wenn Spieler <code>alt</code> in der Mannschaft ist und Spieler
     * <code>neu</code> nicht bereits in der Mannschaft spielt.
     * <p>
     * Dies hat nichts mit dem Auswechseln von Spielern während eines Spiels
     * o.ä. zu tun! Es ist eher eine Art "Transfer".
     *
     * @param alt Alter Spieler, der entfernt werden soll.
     * @param neu Neuer Spieler, der hinzugefügt werden soll.
     * @return <code>false</code> bei einem Fehler, sonst <code>true</code>.
     */
    boolean auswechseln(ISpieler alt, ISpieler neu);

    /**
     * Addiert die Punkte der einzelnen Spieler und liefert die Summe zurück.
     *
     * @return Punktzahl der Mannschaft
     */
    int getPunkte();

    /**
     * Prüft, ob ein Spieler in der Mannschaft spielt.
     *
     * @param spieler Spieler, dessen Mitgliedschaft geprüft werden soll.
     * @return <code>true</code> falls Mitglied, sonst <code>false</code>.
     */
    boolean contains(ISpieler spieler);

    /**
     * Wieviele Spieler spielen in dieser Mannschaft?
     *
     * @return Anzahl der Spieler in der Mannschaft (positive ganze Zahl).
     */
    int size();

}
