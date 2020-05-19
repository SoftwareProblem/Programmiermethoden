package ttt.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Game  implements IGame{
    // Sörens
    private List<IMove> remainingMoves;
    //gemeinsame
    private IPlayer playerO;
    private IPlayer playerX;
    // Michel
    String[][] field;
    int turn;


    public Game(){
        field = new String[3][3];
        remainingMoves = new CopyOnWriteArrayList<>();
        for(int i=0;i<field.length;i++){
            for(int j=0;j<field[0].length;j++){
                field[i][j] = " ! ";
                remainingMoves.add(new Move(i,j));
            }
        }
        turn = 0;
    }

    @Override
    public void setPlayerX(IPlayer p) {
        this.playerX = p;
    }

    @Override
    public void setPlayerO(IPlayer p) {
        this.playerO = p;
    }

    @Override
    public IPlayer currentPlayer() {
        if(turn%2==0 ){
            return this.playerO;
        } else{
            return this.playerX;
        }
    }

    @Override
    public List<IMove> remainingMoves() {
        return remainingMoves;
    }

    @Override
    public void doMove(IMove m) {
        field[m.getRow()][m.getColumn()]= " "+ currentPlayer().getSymbol() +" ";
        remainingMoves.remove(m);
        /*
        for(Iterator<IMove> iterator = remainingMoves.iterator();iterator.hasNext();){
            IMove move = iterator.next();
            if(move.getRow()==m.getRow()){
                if(move.getColumn()==m.getColumn()){
                    field[move.getRow()][move.getColumn()]= " "+ currentPlayer().getSymbol() +" ";
                    System.out.println("test");
                    iterator.remove();
                    System.out.println("test2");
                }
            }
        }*/
    }

    @Override
    public void undoMove(IMove m) {
        field[m.getRow()][m.getColumn()]= " ! ";
        remainingMoves.add(m);
    }

    @Override
    public boolean ended() {
        int evalu = this.evalState(playerO);
        if(evalu==1 || evalu==-1 || evalu == 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int evalState(IPlayer p) {
        char symbol = p.getSymbol();
        if(field[0][0].charAt(1)!= '!' && field[0][0].charAt(1)==field[0][1].charAt(1) && field[0][0].charAt(1)==field[0][2].charAt(1)){
            if(field[0][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        } else if(field[1][0].charAt(1)!= '!' && field[1][0].charAt(1)==field[1][1].charAt(1)&&field[1][0].charAt(1)==field[1][2].charAt(1)){
            if(field[0][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        } else if(field[2][0].charAt(1)!= '!' && field[2][0].charAt(1)==field[2][1].charAt(1)&&field[2][0].charAt(1)==field[2][2].charAt(1)){
            if(field[0][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        } else if(field[0][0].charAt(1)!= '!' && field[0][0].charAt(1)==field[1][1].charAt(1)&&field[0][0].charAt(1)==field[2][2].charAt(1)){
            if(field[0][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        } else if(field[2][0].charAt(1)!= '!' && field[2][0].charAt(1)==field[1][1].charAt(1)&&field[2][0].charAt(1)==field[0][2].charAt(1)){
            if(field[0][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        } else if(field[0][0].charAt(1)!= '!' && field[0][0].charAt(1)==field[1][0].charAt(1)&&field[0][0].charAt(1)==field[2][0].charAt(1)){
            if(field[0][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        } else if(field[0][1].charAt(1)!= '!' && field[0][1].charAt(1)==field[1][1].charAt(1)&&field[0][1].charAt(1)==field[2][1].charAt(1)){
            if(field[0][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        } else if(field[0][2].charAt(1)!= '!' && field[0][2].charAt(1)==field[1][2].charAt(1)&&field[0][2].charAt(1)==field[2][2].charAt(1)){
            if(field[0][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        } else if(remainingMoves().size()==0){
            return 0;
        } else {
            return 666;
        }
    }

    @Override
    public void printField() {
        System.out.println("-------------");
        for (String[] strings : field) {
            System.out.print("|");
            for (int j = 0; j < field[0].length; j++) {
                if (strings[j].equals(" ! ")) {
                    System.out.print("\t|");
                } else {
                    System.out.print(strings[j] + "|");
                }
            }
            System.out.println("\n-------------");
        }
        turn++;
    }
}
