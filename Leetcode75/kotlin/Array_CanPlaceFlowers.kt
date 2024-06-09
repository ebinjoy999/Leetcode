//https://leetcode.com/problems/can-place-flowers

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