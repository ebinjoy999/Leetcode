https://leetcode.com/problems/reverse-vowels-of-a-string/



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