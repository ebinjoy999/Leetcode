https://leetcode.com/problems/group-anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.



----------------- Using HashMap

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val hash: HashMap<String, ArrayList<String>> = hashMapOf()
        for (str in strs) {

            val ar = str.toCharArray()
            ar.sort()
            val key = ar.joinToString()

            if (!hash.contains(key)) {
                hash[key] = arrayListOf()
            } 
            hash[key]!!.apply {  add(str) }
        }
        return ArrayList(hash.values)
    }
}




fun main() {
    val ar = "abs".toCharArray()
    val key = String(ar)
    val key2 = ar.toString()

    println("key $key -- key2 $key2") 
}
prints
key abs -- key2 [C@27bc2616


----------------- 