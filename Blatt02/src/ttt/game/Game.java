package ttt.game;

import java.util.LinkedList;
import java.util.List;

/**
 * Regelt den Spielablauf
 */
public class Game  implements IGame{
    String[][] field;
    int turn;
    private IPlayer playerO;
    private IPlayer playerX;

    /**
     * Initialisiert das Feld und fülllt es mit "leeren" Feldern
     * Initialisiert den Rundenzähler
     */
    public Game(){
        field = new String[3][3];
        turn = 1;
        for(int i=0;i<field.length;i++){
            for(int j=0;j<field[0].length;j++){
                field[i][j] = " ! ";
            }
        }
    }

    /**
     * Setzt den PlayerX auf p
     * @param p ein Spieler
     */
    @Override
    public void setPlayerX(IPlayer p) {
        this.playerX = p;
    }

    public IPlayer getPlayerO() {
        return playerO;
    }

    public IPlayer getPlayerX() {
        return playerX;
    }

    /**
     * Setzt den PlayerO auf p
     * @param p ein Spieler
     */
    @Override
    public void setPlayerO(IPlayer p) {
        this.playerO = p;
    }

    /**
     * Ermittelt über den Rundenzähler welcher Spieler an der Reihe ist
     * @return der Spieler der an der Reihe ist
     */
    @Override
    public IPlayer currentPlayer() {
        if(turn%2==0 ){
            return this.playerO;
        } else{
            return this.playerX;
        }
    }

    /**
     * Überprüft das Spielfeld ob und welche Felder noch frei sind
     * @return gibt die freien Felder als List zurück
     */
    @Override
    public List<IMove> remainingMoves() {
        List<IMove> remainingMoves = new LinkedList<>();
        for(int i=0;i<field.length;i++){
            for(int j=0;j<field[0].length;j++){
                if(field[i][j].charAt(1)=='!'){
                    remainingMoves.add(new Move(i,j));
                }
            }
        }
        return remainingMoves;
    }

    public int getTurn() {
        return turn;
    }

    /**
     * Führt den gegebenen Zug aus
     * @param m der berechnete Zug
     */
    @Override
    public void doMove(IMove m) {
        field[m.getRow()][m.getColumn()]= " "+ currentPlayer().getSymbol() +" ";
    }

    /**
     * Macht den gegeben Zug rückgängig aus
     * @param m der gegebene Zug
     */
    @Override
    public void undoMove(IMove m) {
        field[m.getRow()][m.getColumn()]= " ! ";
    }

    /**
     * Bewertet den aktuellen Status
     * @return wenn das Spiel zuende ist wird true zurückgegeben
     */
    @Override
    public boolean ended() {
        int evalu = this.evalState(playerO);
        if(evalu == 1){
            //System.out.println("PlayerO gewinnt!");
            return true;
        } else if(evalu == -1){
            //System.out.println("PlayerX gewinnt!");
            return true;
        } else if(evalu == 0){
            System.out.println("Unentschieden!");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Überprüft das Feld auf verschiedene Abbruchtypen(Sieg bzw. Niederlage bzw. Unentschieden)
     * @param p aus wessen "Sicht" die Überprüfung stattfindet
     * @return gibt den Status zurück: 1 bei Sieg -1 bei Niederlage 0 bei Unentschieden 666 bei keinem Ende
     */
    @Override
    public int evalState(IPlayer p) {
        char symbol = p.getSymbol();
        //1. Zeile
        if(field[0][0].charAt(1)!= '!' && field[0][0].charAt(1)==field[0][1].charAt(1) && field[0][0].charAt(1)==field[0][2].charAt(1)){
            if(field[0][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        }
        // 2. Zeile
        else if(field[1][0].charAt(1)!= '!' && field[1][0].charAt(1)==field[1][1].charAt(1)&&field[1][0].charAt(1)==field[1][2].charAt(1)){
            if(field[1][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        }
        // 3. Zeile
        else if(field[2][0].charAt(1)!= '!' && field[2][0].charAt(1)==field[2][1].charAt(1)&&field[2][0].charAt(1)==field[2][2].charAt(1)){
            if(field[2][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        }
        // Von oben Links Diagonal
        else if(field[0][0].charAt(1)!= '!' && field[0][0].charAt(1)==field[1][1].charAt(1)&&field[0][0].charAt(1)==field[2][2].charAt(1)){
            if(field[0][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        }
        // von unten Links Diagonal
        else if(field[2][0].charAt(1)!= '!' && field[2][0].charAt(1)==field[1][1].charAt(1)&&field[2][0].charAt(1)==field[0][2].charAt(1)){
            if(field[2][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        }
        // 1. Spalte
        else if(field[0][0].charAt(1)!= '!' && field[0][0].charAt(1)==field[1][0].charAt(1)&&field[0][0].charAt(1)==field[2][0].charAt(1)){
            if(field[0][0].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        }
        // 2. Spalte
        else if(field[0][1].charAt(1)!= '!' && field[0][1].charAt(1)==field[1][1].charAt(1)&&field[0][1].charAt(1)==field[2][1].charAt(1)){
            if(field[0][1].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        }
        // 3. Spalte
        else if(field[0][2].charAt(1)!= '!' && field[0][2].charAt(1)==field[1][2].charAt(1)&&field[0][2].charAt(1)==field[2][2].charAt(1)){
            if(field[0][2].charAt(1)==symbol){
                return 1;
            } else {
                return -1;
            }
        }
        // Unentschieden
        else if(remainingMoves().size()==0){
            return 0;
        }
        // Noch kein Ergebnis
        else {
            return 666;
        }
    }

    /**
     * Gibt das Spielfeld auf der Konsole aus und erhöht den Rundenzähler um eins
     */
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
