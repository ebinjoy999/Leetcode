https://leetcode.com/problems/product-of-array-except-self


Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.




class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        
        var(i,j) = 0 to nums.lastIndex
        var(pLeft, pRight) = 1 to 1
        val numsP = IntArray(nums.size) {1}

        while(i < nums.size ) {
            numsP[i] *= pLeft
            numsP[j] *= pRight

            pLeft *= nums[i]
            pRight *= nums[j]

            i++
            j--
        }
        return numsP
    }
}

Techniques
--Brute force: O(n^2)
can loop through the complete array using a pointer, say j, for every index i, and multiply all the elements at index j except when i == j.

--Dividing the product of array with the number O(n)
0 is our problem only when we are performing division, with multiplication, we have no such problem with 0,

--Finding Prefix Product and Suffix Product [Time-O(n) Space-O(n)]
The Time Complexity would be O(n), but we are now using Auxilary Space of O(n) (excluding the final answer array).
pre[i] = pre[i - 1] * a[i - 1] and similarly suff[i] = suff[i + 1] * a[i + 1].
Now, at any index i our final answer ans[i] would be given by ans[i] = pre[i] * suff[i].

--Directly store the product of prefix and suffix into the final answer array [Time-O(n) Space-O(1)]
^^ Solution
