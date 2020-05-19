package ttt.Charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import ttt.game.Game;

import javax.swing.*;
import java.util.ArrayList;

public class PieChart extends ApplicationFrame {
    private DefaultPieDataset pieDataset;
    private  int[] turns;
    public PieChart(String title) {
            super(title);

            turns=new int[11];
            for (int i=0;i<turns.length-1;i++){
                turns[i]=0;
            }
            setContentPane(panel());
        }

    public void collectPieData(Game game){
        turns[game.getTurn()]++;
    }


        public PieDataset addData(){
            DefaultPieDataset data =new DefaultPieDataset();
            for (int i=0;i<turns.length-1;i++){
                data.setValue(i+"Turns", turns[i]);

            }




            return data;
        }
        private   JFreeChart makeChart(PieDataset data){
            JFreeChart fart = ChartFactory.createPieChart("Hitler oder Sieg", data, true, true, false);
            return fart;

        }
        private  JPanel panel(){
            JFreeChart chart= makeChart(addData());
            return new ChartPanel(chart);
        }

        public void resetPanel(){
            setContentPane(panel());

        }
}
