package bundesliga.generic2;

public interface IMannschaft<T extends ISpieler> {
    boolean aufnehmen(T spieler);
    boolean rauswerfen(T spieler);
    boolean auswechseln(T alt, T neu);

    int getPunkte();
    boolean contains(T spieler);
    int size();
}
