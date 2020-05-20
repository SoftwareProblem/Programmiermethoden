package ttt.Charts;

import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.Dataset;
import ttt.game.Game;

import javax.swing.*;

public  abstract class Charts extends ApplicationFrame {
    public Charts(String title) {
        super(title);
    }

    /**
     * Creates a Dataset out of the collected data
     * @return a Dataset of a specific Type
     */
    protected abstract  <T extends Dataset> T addData();


    /**
     * @param game The Game the data is collected from
     * Collects the needed data from a Game
     */
    public abstract void collectData(Game game);

    protected abstract JPanel panel();


    /**
     * Draws the Chart with the collected data
     */
    public  void drawChart(){
        addData();
        setContentPane(panel());
        setSize(1000, 800);
        setVisible(true);

    }







}
