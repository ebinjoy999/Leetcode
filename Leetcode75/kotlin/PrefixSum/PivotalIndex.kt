https://leetcode.com/problems/find-pivot-index/


The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.


class Solution {
    fun pivotIndex(nums: IntArray): Int {
        //create sum array
        val prefixSum = IntArray(nums.size)
        var sum = 0
        for( i in 0..nums.lastIndex) {
            sum += nums[i]
            prefixSum[i] = sum
        }
        // check 1st position is pivot? total - first
        if(prefixSum[nums.lastIndex] - prefixSum[0] == 0)
            return 0
        for(i in 1..prefixSum.lastIndex) {
            val sumRightSide = prefixSum[prefixSum.lastIndex] - prefixSum[i]
            //if sum of a pistiton left and right same its pivotal
            if(prefixSum[i-1] == sumRightSide)
                return i
        }
        return -1
    }
}