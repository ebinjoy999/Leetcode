//https://leetcode.com/problems/can-place-flowers


You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.


class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var plants = n

        var l = 0

        while(l < flowerbed.size && plants > 0) {
            if(flowerbed[l] == 0 && ( l == 0 || flowerbed[l-1] == 0) && (l == flowerbed.size - 1 || flowerbed[l+1] == 0)) {
                flowerbed[l] = 1
                l = l+2
                plants--
            } else {
                l++
            }
        }

        return plants == 0

    }
}