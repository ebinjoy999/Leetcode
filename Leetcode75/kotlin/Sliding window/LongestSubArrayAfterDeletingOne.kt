
https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element


Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray


class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var maxCount = 0
        var i = 0
        while(i < nums.size) {
            var count = 0
            if (nums[i] == 1) {
                while (i < nums.size && nums[i] == 1){
                    i++
                    count++
                }
                var j = i+1
                while (j < nums.size && nums[j] == 1){
                    j++
                    count++
                }
                if (count == nums.size){
                    count--
                }
                maxCount = maxOf(maxCount, count)
                i++

            } else {
                i++
            }
        }
        return maxCount
    }
}

Time: O(n)
Space: O(1)