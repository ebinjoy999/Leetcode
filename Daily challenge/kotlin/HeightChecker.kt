https://leetcode.com/problems/height-checker

//Using priority Queue

class Solution {
    fun heightChecker(heights: IntArray): Int {
        val pq = PriorityQueue<Int>(heights.size)
        for (h in heights) {
            pq.offer(h)
        }

        var diff = 0
        for (h in heights) {
            if (h != pq.poll()) diff++
        }
        return diff
    }
}



//1 line Solution

class Solution {
    fun heightChecker(heights: IntArray): Int {
        return heights.sorted().mapIndexed{ index, i -> if (i != heights[index]) 1 else 0 }.sum()
    }
}