package ttt.Charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import ttt.game.Game;

import javax.swing.*;


public class PieChart extends Charts {
    private DefaultPieDataset pieDataset;
    private int[] turns;

    public PieChart(String title) {
        super(title);
        turns = new int[12];
        for (int i = 0; i < turns.length - 1; i++) {
            turns[i] = 0;
        }

    }

    @Override
    public void collectData(Game game) {
        turns[game.getTurn()]++;
    }

    @Override
    public PieDataset addData() {
        DefaultPieDataset data = new DefaultPieDataset();
        for (int i = 5; i < turns.length; i++) {
            data.setValue(i - 2 + "Turns", turns[i]);

        }

        return data;
    }


    protected JFreeChart makeChart(PieDataset data) {
        JFreeChart chart = ChartFactory.createPieChart("How many turns", data, true, true, false);
        return chart;

    }

    @Override
    protected JPanel panel() {
        JFreeChart chart = makeChart(addData());
        return new ChartPanel(chart);
    }




}
