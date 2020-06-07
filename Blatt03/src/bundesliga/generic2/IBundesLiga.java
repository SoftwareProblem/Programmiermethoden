package bundesliga.generic2;

public interface IBundesLiga<T extends IMannschaft<? extends FussballSpieler>> {
    boolean aufnehmen(T mannschaft);
    boolean rauswerfen(T mannschaft);
    void sortMannschaften();
    boolean contains(T mannschaft);
    int size();
    T getFirstTeam();
    T getLastTeam();
}
