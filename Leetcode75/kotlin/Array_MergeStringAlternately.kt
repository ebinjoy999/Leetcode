//https://leetcode.com/problems/merge-strings-alternately


class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val sb = StringBuilder()
        for( i in 0 until maxOf(word1.length, word2.length)) {
            word1.getOrNull(i)?.let {
                sb.append(it)   
            }
            word2.getOrNull(i)?.let {
                sb.append(it)
            }
        }
        return sb.toString()
    }
}