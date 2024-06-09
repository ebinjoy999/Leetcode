//https://leetcode.com/problems/greatest-common-divisor-of-strings


class Solution {
	fun gcdOfStrings(str1: String, str2: String): String {
		if (!((str1+str2).equals(str2+str1))) {
			return ""
		}
		val gcd = findGcd(str1.length, str2.length)
		return str1.substring(0, gcd)
	}

	fun findGcd(a: Int, b: Int): Int {
		return if (b==0) a else findGcd(b, a%b)
	}
}

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"