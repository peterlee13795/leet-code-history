class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];  // 가격이 상승하는 부분에서 매도 후 매수
            }
        }
        return profit;
    }
}