https://leetcode.com/problems/product-of-array-except-self


Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.




class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var (i, j) = 0 to nums.size.minus(1)
        var (productLeft, productRight) = 1 to 1
        val numsT = IntArray(nums.size) { 1 }
        
        while (i < nums.size ) {
            val xi = nums[i]
            val xj = nums[j]

            numsT[i] *= productLeft
            numsT[j] *= productRight

            productLeft *= xi
            productRight *= xj

            i++
            j--
        }
        return numsT
    }
}