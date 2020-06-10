package bundesliga.generic2;

/**
 * Generisches Interface nach nicht generischem Interface in bundesliga.polymorph.IMannschaft
 * @param <T> Typvariable die auf Klassen beschränkt ist die von ISpieler erben/abgeleitet werden
 */
public interface IMannschaft<T extends ISpieler> {
    /**
     * Nimmt einen Spieler in die Mannschaft auf.
     * Ein Spieler kann in mehreren verschiedenen Mannschaften spielen, aber in
     * einer Mannschaft nur einmal gelistet sein.
     *
     * Es gibt keine Reihenfolge unter den Spielern einer Mannschaft.
     *
     * @param spieler Spieler, der aufgenommen werden soll.
     * @return false wenn Spieler nicht hinzugefügt werden konnte,
     * sonst true
     */
    boolean aufnehmen(T spieler);
    /**
     * Entfernt einen Spieler aus der Mannschaft.
     *
     * @param spieler Spieler, der entfernt werden soll.
     * @return false wenn Spieler nicht entfernt werden konnte,
     * ansonsten true
     */
    boolean rauswerfen(T spieler);
    /**
     * Wechselt zwei Spieler aus.
     *
     * Der Spieler alt wird aus der Mannschaft geworfen, und der
     * Spieler neu wird in die Mannschaft aufgenommen. Das geht
     * nur, wenn Spieler alt in der Mannschaft ist und Spieler
     * neu nicht bereits in der Mannschaft spielt.
     *
     * Dies hat nichts mit dem Auswechseln von Spielern während eines Spiels
     * o.ä. zu tun! Es ist eher eine Art "Transfer".
     *
     * @param alt Alter Spieler, der entfernt werden soll.
     * @param neu Neuer Spieler, der hinzugefügt werden soll.
     * @return false bei einem Fehler, sonst true
     */
    boolean auswechseln(T alt, T neu);
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
     * @return true falls Mitglied, sonst false
     */
    boolean contains(T spieler);
    /**
     * Wieviele Spieler spielen in dieser Mannschaft?
     *
     * @return Anzahl der Spieler in der Mannschaft (positive ganze Zahl).
     */
    int size();
}
