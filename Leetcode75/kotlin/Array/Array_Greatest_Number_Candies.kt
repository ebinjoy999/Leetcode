https://leetcode.com/problems/kids-with-the-greatest-number-of-candies


There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.

Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.


class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val list = ArrayList<Boolean>(candies.size)
        val lv = candies.foldRight(0) { it, r ->
            if (it > r) it else r
        }
        for (i in candies.indices) {
            list.add(false)
            list[i] = (candies[i] + extraCandies) >= lv
        }
        return list
    }
}