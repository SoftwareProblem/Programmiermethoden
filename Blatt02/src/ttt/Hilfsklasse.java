package ttt;

import ttt.Charts.PieChart;
import ttt.game.*;
import ttt.strategy.GameStrategyClassic;
import ttt.strategy.IGameStrategy;
import ttt.strategy.MinMaxStrategy;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hilfsklasse {
    public static void main(String[] args){
        boolean wantsToPlay= true;
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        Hilfsklasse hilfsklasse = new Hilfsklasse();
        IGame game = new Game();
        hilfsklasse.initGame(game);
        game.printField();
        PieChart pieChartTurns=new PieChart("Turns");
        while (wantsToPlay){
            wantsToPlay=false;
        while(!game.ended()){
            game.doMove(game.currentPlayer().nextMove(game));
            game.printField();


        }
            System.out.println("Do you want to play again? yes/no ");
            try {
                String yesNo=bufferedReader.readLine();
                if (yesNo.equals("yes")||yesNo.equals("Yes")){

                    wantsToPlay=true;
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        pieChartTurns.collectPieData((Game) game);
        }
        pieChartTurns.addData();
        pieChartTurns.resetPanel();
        pieChartTurns.setSize(1000,800);
        pieChartTurns.setVisible(true);

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