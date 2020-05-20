package ttt;

import ttt.Charts.PieChart;
import ttt.game.*;
import ttt.strategy.GameStrategyClassic;
import ttt.strategy.GameStrategyRandom;
import ttt.strategy.IGameStrategy;
import ttt.strategy.MinMaxStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hilfsklasse {
    public static void main(String[] args){
        Hilfsklasse hilfsklasse = new Hilfsklasse();
        Game game;
        PieChart pieChartTurns=new PieChart("Turns played");
        boolean weiterSpielen = true;
        while(weiterSpielen) {
            game = new Game();
            hilfsklasse.initGame(game);
            game.printField();
            while (!game.ended()) {
                game.doMove(game.currentPlayer().nextMove(game));
                game.printField();
                System.out.println(game.getTurn());
            }

            pieChartTurns.collectPieData((Game) game);
            weiterSpielen = Hilfsklasse.weiterSpielen();
        }
        pieChartTurns.addData();
        pieChartTurns.setPanel();
        pieChartTurns.setSize(1000,800);
        pieChartTurns.setVisible(true);


    }
    private static boolean weiterSpielen(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String spielen = "";
        System.out.println("Wollen Sie weiter spielen? y/n");
        try {
            spielen = reader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        if(spielen.equals("y")){
            return true;
        } else if(spielen.equals("n")){
            return false;
        } else {
            System.out.println("Ungültige Eingabe.");
            return weiterSpielen();
        }
    }
    private void initGame(IGame game){
        System.out.println("Spieler0:");
        Player player0 = new Player('o');
        player0.setStrategy(this.askStrategy());
        System.out.println("SpielerX:");
        Player playerX = new Player('x');
        playerX.setStrategy(this.askStrategy());
        game.setPlayerO(player0);
        game.setPlayerX(playerX);
    }

    private IGameStrategy askStrategy(){
        int answer = 1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welche Strategy soll verwendet werden?\n" +
                "1. Classic\n" +
                "2. MinMax\n" +
                "3. Random\n");
        try {
            answer = Integer.parseInt(reader.readLine());
        } catch (IOException e){
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println("Nur natürliche Zahlen eingeben! 1-3!");
            askStrategy();
        }
        if (answer<=0 || answer>=4){
            System.out.println("Ungültige Zahl eingegeben!");
            return askStrategy();
        } else {
            if(answer==1){
                return new GameStrategyClassic();
            } else if(answer==2){
                return new MinMaxStrategy();
            } else {
                return new GameStrategyRandom();
            }
        }
    }
}