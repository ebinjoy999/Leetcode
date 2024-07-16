https://leetcode.com/problems/reverse-vowels-of-a-string/

Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.


class Solution {
	fun reverseVowels(s: String): String {
		val c = s.toCharArray()
		val vowels = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
		var (i, j) = 0 to c.size-1
		while ( i < j) {
			if (i < c.size && vowels.contains(c[i])) {
				while (j > -1 && !vowels.contains(c[j])) {
					j--
				}
				val x = c[j]
				c[j] = c[i]
				c[i] = x
			} else if (j > -1 &&vowels.contains(c[j])) {
				while (i < c.size && !vowels.contains(c[i])) {
					i++
				}
				val x = c[j]
				c[j] = c[i]
				c[i] = x
			}
			i++
			j--
		}
		return c.joinToString("")
	}
}


---------------

class Solution {
    fun reverseVowels(s: String) = with(s.filter { it.isVowel }.reversed()) {
        var vowel = 0
        s.map { it.takeUnless { it.isVowel } ?: get(vowel++) }.joinToString("")
    }
    private val Char.isVowel get() = when(lowercaseChar()) { 'a', 'e', 'i', 'o', 'u' -> true else -> false }
}