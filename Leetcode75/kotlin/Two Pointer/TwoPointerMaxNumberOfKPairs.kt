https://leetcode.com/problems/max-number-of-k-sum-pairs

You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.

class Solution {
fun maxOperations(nums: IntArray, k: Int): Int {
    var count = 0
    var leftIndex = 0
    var rightIndex = nums.lastIndex
    nums.sort()
    while (leftIndex < rightIndex) {
        val left = nums[leftIndex]
        val right = nums[rightIndex]
        val sum = left + right
        when {
            sum > k -> {
                rightIndex--
            }

            sum < k -> {
                leftIndex++
            }

            else -> {
                rightIndex--
                leftIndex++
                count++
            }
        }
    }
    return count
}
}




Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
