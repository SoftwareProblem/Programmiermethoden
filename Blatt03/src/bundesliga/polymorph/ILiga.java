package bundesliga.polymorph;

/**
 * @author Carsten Gips
 */
public interface ILiga {
    /**
     * Fügt eine Mannschaft der Liga hinzu.
     * <p>
     * Eine Mannschaft kann in der Liga nur einmal vorkommen.
     * <p>
     * Es gibt <b>eine</b> Reihenfolge unter den Mannschaften einer Liga
     * (herzustellen über {@link ILiga#sortMannschaften()}).
     *
     * @param mannschaft Mannschaft, die hinzugefügt werden soll.
     * @return <code>false</code> bei einem Fehler, sonst <code>true</code>.
     */
    boolean aufnehmen(IMannschaft mannschaft);

    /**
     * Entfernt eine Mannschaft aus der Liga.
     *
     * @param mannschaft Mannschaft, die entfernt werden soll.
     * @return <code>false</code> bei einem Fehler, sonst <code>true</code>.
     */


    /**
     * Sortiert die Mannschaften der Liga absteigend nach den Punkten der
     * einzelnen Mannschaften
     */
    void sortMannschaften();

    /**
     * Prüft, ob eine Mannschaft in der Liga spielt.
     *
     * @param mannschaft Mannschaft, deren Mitgliedschaft geprüft werden soll.
     * @return <code>true</code> falls Mitglied, sonst <code>false</code>.
     */
    boolean contains(IMannschaft mannschaft);

    /**
     * Wieviele Mannschaften spielen in dieser Liga?
     *
     * @return Anzahl der Mannschaften in der Liga (positive ganze Zahl).
     */
    int size();

    /**
     * Welches Team steht aktuell auf dem ersten Platz der Liga?
     * <p>
     * Ruft vorher {@link ILiga#sortMannschaften()} auf!
     *
     * @return Referenz auf die erste Mannschaft in der Liga; <code>null</code>
     * falls keine Mannschaften vorhanden.
     */
    IMannschaft getFirstTeam();

    /**
     * Welches Team steht aktuell auf dem letzten Platz der Liga?
     * <p>
     * Ruft vorher {@link ILiga#sortMannschaften()} auf!
     *
     * @return Referenz auf die letzte Mannschaft in der Liga; <code>null</code>
     * falls keine Mannschaften vorhanden.
     */
    IMannschaft getLastTeam();

}
