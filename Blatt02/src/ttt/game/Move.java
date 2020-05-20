package ttt.game;

/**
 * Klasse die den Zug repräsentiert
 */
public class Move implements IMove {
    private int row;
    private int column;

    /**
     * Konstruktor der Klasse
     * @param row Zeile des Ziels
     * @param column Spalte des Ziels
     */
    public Move(int row, int column){
        this.row = row;
        this.column = column;
    }

    /**
     * Gibt die Zeile zurück
     * @return die Zeile
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Gibt die Spalte zurück
     * @return die Spalte
     */
    @Override
    public int getColumn() {
        return column;
    }
}
