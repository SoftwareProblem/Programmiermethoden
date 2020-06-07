package bundesliga.generic2;

public class Spieler implements ISpieler{
    String name;
    public Spieler(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPunkte() {
        return 0;
    }

    @Override
    public void score() {

    }
}
