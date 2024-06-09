https://leetcode.com/problems/kids-with-the-greatest-number-of-candies

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