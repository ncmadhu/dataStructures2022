package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Best Time To Buy And Sell Stock 2");
        int[] nums;
        nums =  new int[]{7,1,5,3,6,4};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.maxProfit(nums));
        nums =  new int[]{1,2,3,4,5};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.maxProfit(nums));
        nums =  new int[]{7,6,4,3,1};
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + this.maxProfit(nums));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] < prices[i]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
