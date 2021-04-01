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