package ttt.Charts;

import org.jfree.chart.ui.ApplicationFrame;
import ttt.game.Game;

import javax.swing.*;

public  abstract class Charts extends ApplicationFrame {
    public Charts(String title) {
        super(title);
    }

    public abstract void collectData(Game game);
    public abstract void setPanel();
    protected abstract JPanel panel();



}
