package Algorithms.ReAttempt1.Arrays;

import Algorithms.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockBuyAndSellToMaxProfit extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Stock Buy And Sell To Max Profit Only Once");
        int[][] input = new int[][]{{7,1,5,3,6,4}, {21,12,11,9,6,3}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            List<Integer> positions = this.findBuyAndSellPosition(input[i]);
            System.out.println("Max Profit Positions: " + positions.toString());
            System.out.println("Max Profit Prices: " + this.findBuyAndSellPrice(input[i]).toString());
        }
    }

    private List<Integer> findBuyAndSellPosition(int[] prices) {
        int currProfit = Integer.MIN_VALUE;
        int currBuyPrice = prices[0];
        int sellPrice = prices[1];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            currProfit = prices[i] - currBuyPrice;
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
                sellPrice = prices[i];
            }
            if (prices[i] < currBuyPrice) {
                currBuyPrice = prices[i];
            }
        }
        return Arrays.asList(sellPrice - maxProfit, sellPrice);
    }

    private List<Long> findBuyAndSellPrice(int[] prices) {
        long currProfit = Integer.MIN_VALUE;
        long maxProfit =  Integer.MIN_VALUE;
        long sellPrice = prices[1];
        for (int i = 1; i < prices.length; i++) {
            currProfit = Math.max(prices[i] - prices[i - 1], currProfit + prices[i] - prices[i - 1]);
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
                sellPrice = prices[i];
            }
        }
        return Arrays.asList(sellPrice - maxProfit, sellPrice);
    }
}
