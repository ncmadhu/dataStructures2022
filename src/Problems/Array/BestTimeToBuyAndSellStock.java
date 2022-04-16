package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock extends Problem {
    @Override
    public void run() {
        System.out.println("Running Best Time To Buy And Sell Stock");
        int[] nums;
        nums =  new int[]{7,1,5,3,6,4};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.maxProfit(nums));
        System.out.println("Output Alternate: " + this.maxProfitAlt(nums));
        nums =  new int[]{7,6,4,3,1};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.maxProfit(nums));
        System.out.println("Output Alternate: " + this.maxProfitAlt(nums));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            currProfit = Math.max(prices[i] - prices[i-1], currProfit + prices[i] - prices[i-1]);
            maxProfit = Math.max(currProfit, maxProfit);
        }
        return maxProfit;
    }

    public int maxProfitAlt(int[] prices) {
        int maxProfit = 0;
        int minPriceSoFar = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minPriceSoFar) {
                minPriceSoFar = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPriceSoFar);
            }
        }
        return maxProfit;
    }
}
