# [376. Wiggle Subsequence](https://leetcode.com/problems/wiggle-subsequence/)

Given an integer array `nums`, return *the length of the longest wiggle sequence*.  

A **wiggle sequence** is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.  

* For example, `[1, 7, 4, 9, 2, 5]` is a **wiggle sequence** because the differences `(6, -3, 5, -7, 3)` are alternately positive and negative.
* In contrast, `[1, 4, 7, 2, 5]` and `[1, 7, 4, 5, 5]` are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.  

A **subsequence** is obtained by deleting some elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.  

## Examples

**Example 1:**  
**Input**: `nums = [1,7,4,9,2,5]`  
**Output:** 6  
**Explanation:** The entire sequence is a wiggle sequence.  

**Example 2:**  
**Input:** `nums = [1,17,5,10,13,15,10,5,16,8]`  
**Output:** 7  
**Explanation:** There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].  

**Example 3:**  
**Input:** `nums = [1,2,3,4,5,6,7,8,9]`  
**Output:** 2  
 

## Constraints:  
* `1 <= nums.length <= 1000`
* `0 <= nums[i] <= 1000`
 
 ## My Kotlin Solution
 ```kotlin
class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {
        if (nums.size == 0) return 0
        if (nums.size == 1) return 1
        if ((nums.size == 2) && (nums[0] != nums[1])) return 2
        if ((nums.size == 2) && (nums[0] == nums[1])) return 1
        var count = 1
        var l = 0
        var r = 1
        var prevDiff = 0
        while (r < nums.size) {
            val left = nums[l]
            val right = nums[r]
            val currDiff = left - right
            if (prevDiff == 0) {
                prevDiff = currDiff
                if (left != right) count++
                l++
                r++
                continue
            }
            if (left == right) {
                l++
                r++
                continue
            }
            val prevWiggle = prevDiff > 0
            val currWiggle = currDiff > 0
            if (prevWiggle.xor(currWiggle)) {
                count++
                prevDiff = currDiff
            }
            l++
            r++
        }
        return count
    }
}
```
### Submission Details
**Runtime:** 144 ms, faster than 75.00% of Kotlin online submissions for Wiggle Subsequence.  
**Memory Usage:** 33.6 MB, less than 100.00% of Kotlin online submissions for Wiggle Subsequence.