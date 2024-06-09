//https://leetcode.com/problems/replace-words/description/


class Solution {
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val removeIndexes = arrayListOf<IntRange>()
        var word = ""
        var removedIndexB = 0
        sentence.forEachIndexed { i, c ->
            if (word.isNotEmpty() && (c == ' ' || i == sentence.length - 1)) {
                word += c
                val minRoot = findRoot(word, dictionary)
                if (minRoot != Integer.MAX_VALUE) {
                    val curentIndex = i - removedIndexB
                    val upperIndex = curentIndex - if (c == ' ') 1 else 0
                    val lowerIndex = curentIndex - (word.length - minRoot - 1)
                    removeIndexes.add(IntRange(lowerIndex, upperIndex))
                    removedIndexB += (upperIndex - lowerIndex + 1)
                }
                word = ""
            } else if (c != ' ') {
                word += c
            }
        }
        var s = sentence
        removeIndexes.forEach {
            s = s.removeRange(it)
        }
        return s
    }

    private fun findRoot(word: String, list: List<String>): Int {
        var minRoot = Integer.MAX_VALUE
        list.map {
            it.forEachIndexed { index, c ->
                if (c == word.getOrNull(index)) {
                    if (index == it.length - 1) {
                        minRoot = Math.min(minRoot, index + 1)
                    }
                } else {
                    return@map
                }
            }
        }
        return minRoot
    }
}