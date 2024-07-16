https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75


You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.




class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var answer = 0
        var sum = 0
        
        // Find our first window, sum of the first k elements
        for (i in 0 until k) {
            sum += nums[i]
        }
        
        answer = sum

        // For every other window, update the sum. 
        // Keep track of highest so far.
        for (i in k until nums.size) {
            sum += nums[i] - nums[i - k]
            answer = max(answer, sum)
        }
        
        // Calculate average of the highest we saw and return
        return answer.toDouble() / k
    }
}


Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75