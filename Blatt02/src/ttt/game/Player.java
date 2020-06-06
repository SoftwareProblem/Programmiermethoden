package ttt.game;

import ttt.strategy.IGameStrategy;

/**
 * Klasse die den Spieler repräsentiert
 */
public class Player implements IPlayer {
    private char symbol;
    private IGameStrategy strategy;
    public IGameStrategy getStrategy() {
        return strategy;
    }

    /**
     * Konstruktor des Spielers
     * @param symbol das Symbol das dem Spieler zugewiesen wird
     */
    public Player(char symbol){
        this.symbol = symbol;
    }

    /**
     * Setzt die Strategie des Spielers
     * @param s die zusetzende Strategie
     */
    @Override
    public void setStrategy(IGameStrategy s) {
        this.strategy = s;
    }

    /**
     * Gibt den nächsten Zug zurück
     * @param g das Spiel in welchem der Zug und der Spieler sich befindet
     * @return gibt den näächsten Zug zurück
     */
    @Override
    public IMove nextMove(IGame g) {
        return strategy.nextMove(g);
    }

    /**
     * Gibt das Symbol des Spielers zurück
     * @return das Symbol
     */
    @Override
    public char getSymbol() {
        return this.symbol;
    }
}
