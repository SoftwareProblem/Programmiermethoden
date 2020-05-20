package ttt.strategy;

import ttt.game.IGame;
import ttt.game.IMove;
import ttt.game.IPlayer;
import ttt.game.Move;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Eine Implementierung einer Strategy die den Benutzer die Züge auswählen lässt
 */
public class GameStrategyClassic implements IGameStrategy {
    /**
     * "Berechnet" den nächsten Zug in dem es den Nutzer fragt.
     * @param g Das Spiel in dem man sich befindet
     * @return gibt den "berechneten" Zug aus
     */
    @Override
    public IMove nextMove(IGame g) {
        int row = -1;
        int coloum = -1;
        System.out.println("Spieler "+g.currentPlayer().getSymbol()+" ist an der Reihe.");
        row = askRow()-1;
        coloum = askColoum()-1;
        for(int i=0;i<g.remainingMoves().size();i++){
            if(g.remainingMoves().get(i).getRow()==row){
                if(g.remainingMoves().get(i).getColumn()==coloum){
                    return new Move(row,coloum);
                }
            }
        }
        System.out.println("Feld bereits belegt");
        return nextMove(g);
    }
    private String askEingabe(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    private int askRow(){
        System.out.println("Welche Zeile? Gültige Eingabe:1-3");
        int row = -1;
        try {
            row = Integer.parseInt(askEingabe());
            if(row<=0 || row>=4){
                System.out.println("Nur 1, 2 oder 3 eingeben!");
                return askRow();
            } else {
                return row;
            }
        } catch(NumberFormatException e){
            System.out.println("Nur die natürlichen Zahlen 1-3 eintragen.");
            return askRow();
        }
    }
    private int askColoum(){
        System.out.println("Welche Spalte? Gültige Eingabe:1-3");
        int coloum = -1;
        try {
            coloum = Integer.parseInt(askEingabe());
            if(coloum<=0 || coloum>=4){
                System.out.println("Nur 1, 2 oder 3 eingeben!");
                return askColoum();
            } else {
                return coloum;
            }
        } catch(NumberFormatException e){
            System.out.println("Nur die natürlichen Zahlen 1-3 eintragen.");
            return askColoum();
        }
    }

    @Override
    public String toString() {
        return "Classic";
    }
    //private IMove hopToNext(List<IMove> moves, IPlayer currentPlayer){
      //  return moves.get(0);
    //}
}