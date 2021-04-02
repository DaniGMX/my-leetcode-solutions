# [1. Two Sum](https://leetcode.com/problems/two-sum/)

Given an array of integers `nums` and an integer `target`, return *indices of the two numbers such that they add up to `target`*.  

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

You can return the answer in any order.

## Examples

**Example 1:**  
<pre>
<b>Input:</b> `nums = [2,7,11,15], target = 9`  
<b>Output:</b> `[0,1]`  
<b>Explanation:</b> Because nums[0] + nums[1] == 9, we return [0, 1].  
</pre>

**Example 2:**  
<pre>
<b>Input:</b> `nums = [3,2,4], target = 6`  
<b>Output:</b> `[1,2]`  
</pre>

**Example 3:** 
<pre>
<b>Input:</b> `nums = [3,3], target = 6`  
<b>Output:</b> `[0,1]`  
</pre>


## Constraints:  
* `2 <= nums.length <= 103`
* `-109 <= nums[i] <= 109`
* `-109 <= target <= 109`
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