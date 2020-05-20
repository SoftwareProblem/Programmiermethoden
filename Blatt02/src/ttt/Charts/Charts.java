package ttt.Charts;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xml.DatasetReader;
import ttt.game.Game;

import javax.swing.*;

public  abstract class Charts extends ApplicationFrame {
    public Charts(String title) {
        super(title);
    }

    protected abstract  <T extends Dataset> T addData();
    public abstract void collectData(Game game);
    public void setPanel(){
        setContentPane(panel());
    }
    protected abstract JPanel panel();
    public  void drawChart(){
        addData();
        setPanel();
        setSize(1000, 800);
        setVisible(true);

    };







}
