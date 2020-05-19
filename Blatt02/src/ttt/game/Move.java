package ttt.game;

public class Move implements IMove {
    private int row;
    private int column;

    public Move(int row, int column){
        this.row = row;
        this.column = column;
    }
    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }
}
