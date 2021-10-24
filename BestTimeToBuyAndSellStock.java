//problem link:https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
import java.io.*;
import java.util.*;

public class BestTimeToBuyAndSellStock {
    //Time Complexity:O(n)
    //Space complexity: O(1)
    public int maxProfit(int[] prices) {
        int costPrice = prices[0], profit = 0;
        for(int i = 1; i < prices.length; i++){
            profit = Math.max(profit, prices[i]-costPrice);
            costPrice = Math.min(costPrice, prices[i]);
        }
        return profit;
    }
    //Time Complexity:O(n^2)
    //Space complexity: O(1)
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            for (int j = i+1; j < prices.length; j++) {
                profit = Math.max(profit, prices[j]-prices[i]);
            }
        }
        return profit;
    }
}
