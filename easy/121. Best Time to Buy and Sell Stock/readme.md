# [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

You want to maximize your profit by choosing a **single** day to buy one stock and choosing a **different day in the future** to sell that stock.

Return *the maximum profit you can achieve from this transaction*. If you cannot achieve any profit, return `0`.

## Examples

**Example 1:**  
<pre>
<b>Input:</b> prices = [7,1,5,3,6,4]
<b>Output:</b> 5
<b>Explanation:</b> Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell. 
</pre>

**Example 2:**  
<pre>
<b>Input:</b> prices = [7,6,4,3,1]
<b>Output:</b> 0
<b>Explanation:</b> In this case, no transactions are done and the max profit = 0.  
</pre>

**Example 3:** 
<pre>
<b>Input:</b> nums = [3,3], target = 6
<b>Output:</b> [0,1]
</pre>


## Constraints:  
* `1 <= prices.length <= 10^5`
* `0 <= prices[i] <= 10^4`
* **Only one valid answer exists.**
 
 ## My Kotlin Solution
 ```kotlin
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        
        for (i in 0..nums.size) {
            val rem = target - nums[i]
            if (map.containsKey(rem)) return intArrayOf(map[rem]!!, i)
            map[nums[i]] = i
        }
        
        return intArrayOf(0, 0)
    }
}
```
### Best Submission Details
**Date:** 04/02/2021 - 01:45
**Runtime:** 188 ms
**Memory Usage:** 37 MB