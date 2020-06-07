package bundesliga.generic2;

public interface ILiga<T extends IMannschaft> {
    boolean aufnehmen(T mannschaft);
    boolean rauswerfen(T mannschaft);
    void sortMannschaften();
    boolean contains(T mannschaft);
    int size();
    T getFirstTeam();
    T getLastTeam();
}
