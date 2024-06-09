https://leetcode.com/problems/subarray-sums-divisible-by-k

// 1 Brute force - performance X
// 2 Prefix sum with hashMap (if the remainder is occuring again,it means between both of the remainders there will be
// definitely a sum of all elements where the sum is divisible by K);;When you need to determine subarrays that meet a
// specific sum condition, such as being equal to a given value or divisible by a number.

class Solution {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        var prefix = 0
        val prefixHash = hashMapOf(0 to 1)
        var count = 0
        for (n in nums) {
            prefix += n
            var mod = prefix % k
            if (mod < 0) {
                mod = k + mod
            }

            if (prefixHash.contains(mod)) {
                count += prefixHash[mod]!!
                prefixHash[mod] = prefixHash[mod]!! + 1
            } else {
                prefixHash[mod] = 1
            }
        }
        return count
    }
}