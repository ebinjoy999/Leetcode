https://leetcode.com/problems/valid-anagram/


Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false



    class Solution {
        fun isAnagram(s: String, t: String): Boolean {

            val map: HashMap<Char, Int> = hashMapOf()

            for (c in s.toCharArray()) {
                map[c] = map.getOrDefault(c, 0) + 1
            }

            for (c in t.toCharArray()) {
                val count = map.getOrDefault(c, 0)
                if (count == 1) {
                    map.remove(c)
                } else {
                    map[c] = count-1
                }
            }

            return map.isEmpty()
        }
    }