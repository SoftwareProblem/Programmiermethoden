package ttt.game;

public class Move implements IMove {
    private int row;
    private int column;
    Move(int row, int column){
        setRow(row);
        setColumn(column);

    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }
}
