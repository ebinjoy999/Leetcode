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


// Two pointer solution

class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        
        var (i, j) = 0 to 0
        fun loopForNext(){
            while(i < nums.size && nums[i] != 0) {
                i++
            }
            while(j < nums.size && nums[j] == 0 || j<i) {
                j++
            }
        }
        
        loopForNext()
        if(i < j)
            while(i < nums.size && j < nums.size) {
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                loopForNext()
            }
    }
    
}
