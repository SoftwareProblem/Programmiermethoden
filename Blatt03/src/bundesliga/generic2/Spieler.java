package bundesliga.generic2;

public class Spieler implements ISpieler{
    String name;
    int punkte;
    public Spieler(String name){
        this.punkte = 0;
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPunkte() {
        return this.punkte;
    }

    @Override
    public void score() {
        this.punkte++;
    }
}
