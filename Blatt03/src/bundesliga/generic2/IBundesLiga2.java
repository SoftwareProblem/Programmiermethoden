package bundesliga.generic2;

public interface IBundesLiga2 extends ILiga<IMannschaft<? extends FussballSpieler>>{
    /**
     * Fügt eine Mannschaft der Liga hinzu.
     *
     * Eine Mannschaft kann in der Liga nur einmal vorkommen.
     *
     * Es gibt eine Reihenfolge unter den Mannschaften einer Liga
     * (herzustellen über bundesliga.generic2.IBundesLiga2#sortMannschaften()
     *
     * @param mannschaft Mannschaft, die hinzugefügt werden soll.
     * @return false bei einem Fehler, sonst true
     */
    boolean aufnehmen(IMannschaft<? extends FussballSpieler> mannschaft);

    /**
     * Entfernt eine Mannschaft aus der Liga.
     *
     * @param mannschaft Mannschaft, die entfernt werden soll.
     * @return <code>false</code> bei einem Fehler, sonst <code>true</code>.
     */
    boolean rauswerfen(IMannschaft<? extends FussballSpieler> mannschaft);
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
    boolean contains(IMannschaft<? extends FussballSpieler> mannschaft);
    /**
     * Wieviele Mannschaften spielen in dieser Liga?
     *
     * @return Anzahl der Mannschaften in der Liga (positive ganze Zahl).
     */
    int size();
    /**
     * Welches Team steht aktuell auf dem ersten Platz der Liga?
     * <p>
     * Ruft vorher bundesliga.generic.IBundesLiga2#sortMannschaften()
     *
     * @return Referenz auf die erste Mannschaft in der Liga; <code>null</code>
     * falls keine Mannschaften vorhanden.
     */
    IMannschaft<? extends FussballSpieler> getFirstTeam();
    /**
     * Welches Team steht aktuell auf dem letzten Platz der Liga?
     * <p>
     * Ruft vorher bundesliga.generic2.IBundesLiga2#sortMannschaften() auf!
     *
     * @return Referenz auf die letzte Mannschaft in der Liga; <code>null</code>
     * falls keine Mannschaften vorhanden.
     */
    IMannschaft<? extends FussballSpieler> getLastTeam();
}
