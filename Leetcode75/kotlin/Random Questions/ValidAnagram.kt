https://leetcode.com/problems/valid-anagram/


Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

------------------ Using HashMap
    class Solution {
        fun isAnagram(s: String, t: String): Boolean {

            if(s.length != t.length) return false

            val hash: HashMap<Char, Int> = hashMapOf()
            for (c in s) {
                hash[c] = hash.getOrDefault(c, 0) + 1
            }

            for (c in t) {
                val freq = hash.getOrDefault(c, 0)
                if (freq==1) {
                    hash.remove(c)
                } else {
                    hash[c] = freq - 1
                }
            }

            return hash.isEmpty()
        }
    }


------------  Using Sort
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        val sa = s.toCharArray()
        sa.sort()
        val ta = t.toCharArray()
        ta.sort()
        for (i in sa.indices) {
            if (sa[i] != ta[i])
                return false
        }
        return true
    }
}


------------  Using Selection Sort
//worst complexity

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        val sa = sortArraySelectionSort(s.toCharArray())
        val ta = sortArraySelectionSort(t.toCharArray())
        for (i in sa.indices) {
            if (sa[i] != ta[i])
                return false
        }
        return true
    }

    fun sortArraySelectionSort(a: CharArray): CharArray {

        var i = 0

        while (i < a.size) {

            var (md, j) = i to i+1
            while (j < a.size) {
                if (a[md] > a[j]) {
                    md = j
                }
                j++
            }

            if (md != i) {
                val t = a[md]
                a[md] = a[i]
                a[i] = t
            }
            i++
        }
        return a
    }
}





