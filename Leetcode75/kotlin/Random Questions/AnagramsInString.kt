https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

Given two strings s and p, return an array of all the start indices of p's 
anagrams in s. You may return the answer in any order.


Input: s = "cbaebabacd", p = "abc"
Output: [0,6]


------------ 8 ms Beats 100.00%

class Solution {

    fun findAnagrams(s: String, p: String): List<Int> {
        val array = arrayListOf<Int>()
        val len = p.length
        
        // Array will be keeping the frequesncies of 26 alphabets in each index 0 to 25
        val freqArray = IntArray(26)

        for (c in p) {
            //adding frequencies of letters in of prefix word to array
            freqArray[c - 'a']++
        }

        for (i in s.indices) {

            // adding frequency of new char at index i
            freqArray[s[i] - 'a']--
            
            // remove frequency of char at index - len
            // len will be our window size
            if (i >= len) freqArray[s[i-len] - 'a']++
            
            // After substract frequency and all occurance is zero, we have anagram match and we can add postion
            if (freqArray.find { it != 0 } == null) array.add(i - len + 1)
        }
        
        return array
    }
}





------------ 1226ms. Beats18.63% - NlogN

class Solution {

    fun findAnagrams(s: String, p: String): List<Int> {
        val ps = p.toCharArray()
        ps.sort()
        return isAnagram(s, String(ps), 0, arrayListOf())
    }

    fun isAnagram(s: String, p: String, i: Int, answer: ArrayList<Int>): List<Int> {
        val pl = p.length
        if (i + pl > s.length) {
            return answer
        }

        val sa = s.substring(i , i + pl).toCharArray()
        sa.sort()
        if(p == String(sa)) {
            answer.add(i)
        }

        return isAnagram(s, p, i+1, answer)
    }
}
