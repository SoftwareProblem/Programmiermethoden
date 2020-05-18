package ttt.game;

import ttt.strategy.IGameStrategy;

public class Player implements IPlayer {

    private IGameStrategy strategy;
    private char symbol;
    private IMove currentMove;

    public IMove getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(IMove currentMove) {
        this.currentMove = currentMove;
    }

    Player (char symbol){
        setSymbol(symbol);
    };

    @Override
    public void setStrategy(IGameStrategy s) {

    }

    @Override
    public IMove nextMove(IGame g) {
        return strategy.nextMove(g);
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public char getSymbol() {
        return 0;
    }
}
