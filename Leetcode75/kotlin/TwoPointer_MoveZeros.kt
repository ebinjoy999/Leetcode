https://leetcode.com/problems/move-zeroes/


Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.


class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var lastNonZeroIndex = 0 
        
        // Move all non-zero elements to the front
        for (i in nums.indices) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex] = nums[i]
                lastNonZeroIndex++
            }
        }

        // Fill the remaining space with zeroes
        for (i in lastNonZeroIndex until nums.size) {
            nums[i] = 0
        }
    }
}