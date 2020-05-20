package ttt.Charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import ttt.game.Game;

import javax.swing.*;
import java.util.ArrayList;

/**
 * A Linechart that shows ne number of won games for every round played
 */
//Rounds won by Player
public class LineChart extends Charts {


    private int round;
    private ArrayList<Integer> wonByO;
    private ArrayList<Integer> wonByX;

    public LineChart(String title){
            super(title);
            round=0;
           wonByO=new ArrayList<Integer>();
           wonByX=new ArrayList<Integer>();

        }


    /**
     * @param game The Game the data is collected from
     * Counts the won games of the Players
     */
    @Override
    public void collectData(Game game) {
            round++;
            if(game.evalState(game.getPlayerO())==1){
               wonByO.add(1);

            }
            else if(game.evalState(game.getPlayerO())==0||game.evalState(game.getPlayerO())==-1){
                wonByO.add(0);

            }
            if(game.evalState(game.getPlayerX())==1){
            wonByX.add(1);

             }
                 else if(game.evalState(game.getPlayerX())==0||game.evalState(game.getPlayerX())==-1){
            wonByX.add(0);

             }

    }


    @Override
    protected DefaultCategoryDataset addData (){
        DefaultCategoryDataset data=new DefaultCategoryDataset();
        int playerOCount=0;
        int playerXCount=0;
        for (int i=0;i<round;i++){
            playerOCount+=wonByO.get(i);
            playerXCount+=wonByX.get(i);
            data.addValue(playerOCount, "PlayerO", "Round"+i);
            data.addValue(playerXCount, "PlayerX", "Round"+i);
        }

        return data;

    }


    private JFreeChart makeChart(DefaultCategoryDataset data){
        JFreeChart chart = ChartFactory.createLineChart("Rounds won by Player", "Rounds", "Won", data);
        return chart;

    }


    @Override
    protected JPanel panel() {
        JFreeChart chart= makeChart(addData());
        return new ChartPanel(chart);
    }


}
