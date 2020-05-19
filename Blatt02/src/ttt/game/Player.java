package ttt.game;

import ttt.strategy.IGameStrategy;

public class Player implements IPlayer {
    private char symbol;
    private IGameStrategy strategy;
    private IMove currentMove;

    public Player(char symbol){
        this.symbol = symbol;
    }

    @Override
    public void setStrategy(IGameStrategy s) {
        this.strategy = s;
    }

    @Override
    public IMove nextMove(IGame g) {
        return strategy.nextMove(g);
    }

    @Override
    public char getSymbol() {
        return this.symbol;
    }
}
