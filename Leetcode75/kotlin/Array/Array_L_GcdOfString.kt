//https://leetcode.com/problems/greatest-common-divisor-of-strings


For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.




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