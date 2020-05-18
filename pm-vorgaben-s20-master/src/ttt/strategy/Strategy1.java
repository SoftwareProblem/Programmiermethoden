package ttt.strategy;

import ttt.game.IGame;
import ttt.game.IMove;
import ttt.game.IPlayer;

import java.util.List;

public class Strategy1 implements IGameStrategy {
    @Override
    public IMove nextMove(IGame g) {
        hopToNext(g.remainingMoves(), g.currentPlayer());


        return null;
    }
    private IMove hopToNext(List<IMove> moves, IPlayer currentPlayer){
        return moves.get(0);

    }


}
