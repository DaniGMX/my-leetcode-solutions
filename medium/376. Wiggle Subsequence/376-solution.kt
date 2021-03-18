package WiggleSubsequence

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
