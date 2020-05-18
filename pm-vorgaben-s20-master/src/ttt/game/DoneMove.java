package ttt.game;

public class DoneMove implements IMove {
    private char symbol;
    private Move move;

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    DoneMove(IMove move,IPlayer player) {
         setMove(move);
         setSymbol(player.getSymbol());
    }


    @Override
    public int getRow() {
        return move.getRow();
    }

    @Override
    public int getColumn() {
        return move.getColumn();
    }
}
