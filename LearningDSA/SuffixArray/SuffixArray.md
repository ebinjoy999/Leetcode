
# Suffix Array
suffix array is an array which contains all the sorted suffixes of a string.
SA for cammel is

```
0 camel
1 amel
2 mel
3 el
4 l

 |
 ˅
1 amel
0 camel
3 el
4 l
2 mel
```

The actual ‘suffix array’ is the array of sorted indices. Because in INDICES WHERE suffx starts.

The suffix array provides a space efficient alternative to a suffix tree which itself is a compressed version of a trie.
NOTE: suffix arrays can do everything suffix trees can, with some additional information such as a Longest Common Prefix (LCP) array.

# Longest Common Prefix (LCP) --------

LCP value: The LCP value at index  i is the length of the longest common prefix between the suffix at index i and the suffix at index i-1 in sorted array.

```
Sorted Index	LCP Suffix
5				0	AB
0				2	ABABBAB
2				2	ABBAB
6				0	B
4				1	BAB
1				3	BABBAB
3				1	BBAB
```

By convention, LCP[0] is undefined, but for most purposes it’s fine to set it to zero(so not interfeare).

NOTE: There exists many methods for efficiently constructing the LCP array in 0(nlog(n)) and O(n)..Linear.

# Finding Unique substring --------

The naive algorithm generates all substrings and places them in a set resulting in a 0(n^2) algorithm.
A better approach is to use the LCP array. This provides not only a quick but also a space efficient solution.

(1.png)
String "AZAZA" has n(n+1)/2 = 15 substrings
Calculating its LCP

LCP Array: The LCP array tells you how many characters each suffix shares with the previous one. By summing up the LCP values, you effectively count how many substrings overlap between consecutive suffixes.

(2.png)
The overlaps represent non-unique substrings, so subtracting the total of LCP values from the total substrings gives the number of unique substrings.


https://github.com/williamfiset/DEPRECATED-data-structures/tree/master/com/williamfiset/datastructures/suffixarray 


# [K common substring]/[Longest common substring] problem ----

Suppose we have n strings, how do we find the longest common substring that appears in at least 2 <= K <= n of the strings?

Consider n=3, k=2 with:
<br />
S1 = 'a***bca***'
s2 = '***bca***d'
S3 = 'daca'

'bca' is logest common substring










