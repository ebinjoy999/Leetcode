//https://leetcode.com/problems/increasing-triplet-subsequence


Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.




class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        var (firstSmallest, secondSmallest) = Int.MAX_VALUE to Int.MAX_VALUE
        for (num in nums) {
            if (num <= firstSmallest) {
                firstSmallest = num
            } else if (num <= secondSmallest) {
                secondSmallest = num
            } else {
                return true
            }
        }
        return false
    }
}



-----

Loop through items and we wil store the smallest first (nums[i]) and second number (nums[j]). If third come will return true.
The iteration proceeds from left to right, maintaining the order of indices as i < j < k.