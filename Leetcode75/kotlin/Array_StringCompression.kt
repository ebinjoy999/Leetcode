//https://leetcode.com/problems/string-compression



Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.



class Solution {
  fun compress(chars: CharArray): Int {
    var len = 0
    var i = 0
    while (i < chars.size) {
      var j = i
      while (i + 1 < chars.size && chars[i + 1] == chars[i])
        i++
      chars[len++] = chars[i]
      if (j != i) {
        for (ch in (i + 1 - j).toString())
          chars[len++] = ch
      }
      i++
    }
    return len
  }

}