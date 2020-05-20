package ttt.Charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import ttt.game.Game;
import ttt.game.IPlayer;
import ttt.game.Player;
import ttt.strategy.GameStrategyClassic;
import ttt.strategy.GameStrategyRandom;
import ttt.strategy.MinMaxStrategy;

import javax.swing.*;

public class BarChart extends Charts {
    //counts the wins by strategies

    private int classic;
    private int random;
    private int minMax;

    public BarChart(String title) {
        super(title);
        classic = 0;
        random = 0;
        minMax = 0;
    }

    @Override
    public void collectData(Game game) {
        whatWon(game);
    }


    @Override
    protected JPanel panel() {
        JFreeChart chart = makeChart(addData());
        return new ChartPanel(chart);
    }


    @Override
    public CategoryDataset addData() {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        data.addValue(classic, "Classic", "Wins");
        data.addValue(random, "Random", "Wins");
        data.addValue(minMax, "MinMax", "Wins");

        return data;
    }

    public JFreeChart makeChart(CategoryDataset data) {
        JFreeChart chart = ChartFactory.createBarChart("Wins by Strategy", "Strategy", "Wins", data);

        return chart;

    }


    /**
     * @param game
     * Finds if a and which Player has won a game
     */
    private void whatWon(Game game) {
        if (game.evalState(game.currentPlayer()) == 1) {

            countStrategyUP(game.currentPlayer());
        } else {
            if (game.currentPlayer().getSymbol() == 'O') {

                countStrategyUP(game.getPlayerX());
            } else {
                countStrategyUP(game.getPlayerO());
            }
        }


    }


    /**
     * @param Iplayer
     * Finds out which Strategy was used by the Player who won and counts it.
     */
    private void countStrategyUP(IPlayer Iplayer) {
        Player player = (Player) Iplayer;
        if (player.getStrategy().equals(GameStrategyClassic.class)) {
            classic++;
        } else if (player.getStrategy().getClass().equals(GameStrategyRandom.class)) {
            random++;
        } else if (player.getStrategy().getClass().equals(MinMaxStrategy.class)) {
            minMax++;

        }

    }


}