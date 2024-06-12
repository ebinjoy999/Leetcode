https://leetcode.com/problems/container-with-most-water


You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.

Notice that you may not slant the container.




class Solution {
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var (i, j) = Pair(0, height.size - 1)
        while (i < j) {
            maxArea = maxOf( (j - i) * minOf(height[i], height[j]),maxArea)
            if (height[i] < height[j]) {
                i++
            } else {
                j--
            }
        }
        return maxArea
    }
}

