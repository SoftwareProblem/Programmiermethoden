package ttt.game;

import java.util.List;

public class Game  implements IGame{
    private List<IMove> remainingMoves;
    private List<DoneMove> doneMoves;
    private IPlayer playerO;
    private IPlayer playerX;

    public void setCurrentPlayer(IPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    private IPlayer currentPlayer;
    Game(){
        setPlayerO(new Player('O'));
        setPlayerX(new Player('X'));
        setCurrentPlayer(playerX);
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                remainingMoves.add(new Move(i, j));

            }

        }


    }

    public void playRound(){
        while(!ended()) {
            nextPlayer();
            doMove(currentPlayer.nextMove(this));
        }


    }

    @Override
    public void setPlayerX(IPlayer p) {

    }

    @Override
    public void setPlayerO(IPlayer p) {

    }



    @Override
    public IPlayer currentPlayer() {
        return currentPlayer;
    }
    public void nextPlayer(){
        if (currentPlayer.equals(playerX)){
            setCurrentPlayer(playerO);
        }
        else  if (currentPlayer.equals(playerO)){

            setCurrentPlayer(playerX);

        }

    }

    @Override
    public List<IMove> remainingMoves() {
        return remainingMoves;
    }

    @Override
    public void doMove(IMove m) {
        doneMoves.add(new DoneMove(m, currentPlayer));
        remainingMoves.remove(m);

    }

    @Override
    public void undoMove(IMove m) {
        for (int i=0;i<doneMoves.size();i++){
            if(doneMoves.get(i).getMove().equals(m)){

                remainingMoves.add(doneMoves.get(i).getMove());
                doneMoves.remove(i);

            }


        }

    }

    @Override
    public boolean ended() {

        if (remainingMoves.isEmpty()){
            return true;

        }
        else {return false;}
    }

    @Override
    public int evalState(IPlayer p) {
        return 0;
    }

    @Override
    public void printField() {

    }
}
