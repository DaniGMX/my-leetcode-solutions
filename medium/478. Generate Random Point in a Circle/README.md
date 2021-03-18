# [478. Generate Random Point in a Circle](https://leetcode.com/problems/generate-random-point-in-a-circle/)

Given the radius and x-y positions of the center of a circle, write a function `randPoint` which generates a uniform random point in the circle.  

A **wiggle sequence** is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.  

Note:

1. input and output values are in floating-point.
2. radius and x-y position of the center of the circle is passed into the class constructor.
3. a point on the circumference of the circle is considered to be in the circle.
4. randPoint returns a size 2 array containing x-position and y-position of the random point, in that order. 

## Examples

**Example 1:**  
<pre>
<b>Input</b>: ["Solution","randPoint","randPoint","randPoint"]
[[1,0,0],[],[],[]]
<b>Output:<b> 6  
<b>Explanation:<b> The entire sequence is a wiggle sequence.
</pre>

**Example 2:**  
<pre>
<b>Input:<b> nums = [1,17,5,10,13,15,10,5,16,8]
<b>Output:<b> 7  
<b>Explanation:<b> There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].  
</pre>

**Example 3:**  
<pre>
<b>Input:<b> `nums = [1,2,3,4,5,6,7,8,9]`
<b>Output:<b> 2
</pre>
 

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