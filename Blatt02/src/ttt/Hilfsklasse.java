package ttt;

import ttt.game.*;
import ttt.strategy.GameStrategyClassic;
import ttt.strategy.IGameStrategy;
import ttt.strategy.MinMaxStrategy;

public class Hilfsklasse {
    public static void main(String[] args){
        Hilfsklasse hilfsklasse = new Hilfsklasse();
        IGame game = new Game();
        hilfsklasse.initGame(game);
        game.printField();
        while(!game.ended()){
            game.doMove(game.currentPlayer().nextMove(game));
            game.printField();
        }
    }

    private void initGame(IGame game){
        Player player0 = new Player('o');
        player0.setStrategy(this.askStrategy(0));
        Player playerX = new Player('x');
        playerX.setStrategy(this.askStrategy(1));
        game.setPlayerO(player0);
        game.setPlayerX(playerX);
    }

    private IGameStrategy askStrategy(int a){
        int answer = a;
        if(answer==0){
            return new GameStrategyClassic();
        } else if(answer==1){
            return new MinMaxStrategy();
        }
        return null;
    }
}