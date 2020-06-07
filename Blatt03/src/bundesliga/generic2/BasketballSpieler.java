package bundesliga.generic2;

public class BasketballSpieler extends Spieler{
    public BasketballSpieler(String name) {
        super(name);
    }

    public void wirfKorb(){
        this.score();
        this.score();
    }
}
