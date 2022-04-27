package ReAttempt.Arrays;

import Common.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockBuyAndSellToMaxProfit extends Problem {
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
            positions = this.reAttemptPosition(input[i]);
            System.out.println("Max Profit Positions (Re Attempt): " + positions.toString());
            System.out.println("Max Profit Prices: " + this.findBuyAndSellPrice(input[i]).toString());
            System.out.println("Max Profit Prices (Re Attempt): " + this.reAttemptBuyAndSellPrice(input[i]).toString());
        }
    }

    private List<Long> reAttemptBuyAndSellPrice(int[] prices) {
        int length = prices.length;
        List<Long> price = new ArrayList<>();
        if (length < 2) return price;
        long currProfit = Integer.MIN_VALUE;
        long maxProfit = Integer.MIN_VALUE;
        long sellPrice = prices[1];
        for (int i = 1; i < length; i++) {
            currProfit = Math.max( prices[i] - prices[i-1], currProfit + prices[i] - prices[i-1]);
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
                sellPrice = prices[i];
            }
        }
        price.add(sellPrice - maxProfit);
        price.add(sellPrice);
        return price;
    }

    private List<Integer> reAttemptPosition(int[] prices) {
        List<Integer> positions = new ArrayList<>();
        int length = prices.length;
        if (length < 2) return positions;
        int currBuyPosition = 0;
        int buyPosition = 0;
        int sellPosition = 1;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++) {
            int currProfit = prices[i] - prices[currBuyPosition];
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
                sellPosition = i;
                buyPosition = currBuyPosition;
            }
            if (prices[i] < prices[currBuyPosition]) {
                currBuyPosition = i;
            }
        }
        positions.add(buyPosition);
        positions.add(sellPosition);
        return positions;
    }

    private List<Integer> findBuyAndSellPosition(int[] prices) {
        int buyPosition = 0;
        int currBuyPosition = 0;
        int sellPosition = 1;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - prices[currBuyPosition];
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
                sellPosition = i;
                buyPosition = currBuyPosition;
            }
            if (prices[i] < prices[currBuyPosition]) {
                currBuyPosition = i;
            }
        }
        return Arrays.asList(buyPosition, sellPosition);
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
