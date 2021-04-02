class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = Int.MAX_VALUE
        var max = 0
        for (i in 0..prices.size - 1) {
            if (prices[i] < min) min = prices[i]
            else if (prices[i] - min > max) max = prices[i] - min
        }
        return max
    }
}