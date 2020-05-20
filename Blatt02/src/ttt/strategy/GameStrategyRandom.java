package ttt.strategy;

import ttt.game.IGame;
import ttt.game.IMove;
import ttt.game.Move;

import java.util.Random;

/**
 * Eine Implementierung einer Strategy die zufällig einen Zug "berechnet"
 */
public class GameStrategyRandom implements IGameStrategy{
    @Override
    public IMove nextMove(IGame g) {
        Random rand = new Random();
        int row = rand.nextInt(3);
        int coloum = rand.nextInt(3);
        for(int i=0;i<g.remainingMoves().size();i++){
            if(g.remainingMoves().get(i).getRow()==row){
                if(g.remainingMoves().get(i).getColumn()==coloum){
                    return new Move(row,coloum);
                }
            }
        }
        return nextMove(g);
    }

    @Override
    public String toString() {
        return "Random";
    }
}
