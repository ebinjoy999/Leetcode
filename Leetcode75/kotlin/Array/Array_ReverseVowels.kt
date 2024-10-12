https://leetcode.com/problems/reverse-vowels-of-a-string/

Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.


class Solution {
    fun reverseVowels(s: String): String {
        
        var (i, j) = 0 to s.length - 1
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val sChars = s.toCharArray()

        while (i < j) {
            if (vowels.contains(sChars[i]) && vowels.contains(sChars[j])) {
                val temp = sChars[j]
                sChars[j] = sChars[i]
                sChars[i] = temp
                i++
                j--
            } else if (vowels.contains(sChars[i])) {
                    j--
             } else if (vowels.contains(sChars[j])) {
                    i++
             } else {
                 i++
                j--
             }
        }
        return sChars.joinToString("")

    }
}


--------------- Twom Pointer

class Solution {
    fun reverseVowels(s: String) = with(s.filter { it.isVowel }.reversed()) {
        var vowel = 0
        s.map { it.takeUnless { it.isVowel } ?: get(vowel++) }.joinToString("")
    }
    private val Char.isVowel get() = when(lowercaseChar()) { 'a', 'e', 'i', 'o', 'u' -> true else -> false }
}