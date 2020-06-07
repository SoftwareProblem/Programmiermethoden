package bundesliga.generic2;

public interface IBundesLiga2{
    boolean aufnehmen(IMannschaft<? extends FussballSpieler> mannschaft);
    boolean rauswerfen(IMannschaft<? extends FussballSpieler> mannschaft);
    void sortMannschaften();
    boolean contains(IMannschaft<? extends FussballSpieler> mannschaft);
    int size();
    IMannschaft<? extends FussballSpieler> getFirstTeam();
    IMannschaft<? extends FussballSpieler> getLastTeam();
}
