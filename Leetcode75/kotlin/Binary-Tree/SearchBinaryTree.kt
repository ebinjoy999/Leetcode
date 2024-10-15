https://leetcode.com/problems/search-in-a-binary-search-tree/


Recursion

class Solution {
    var answer: TreeNode? = null
    
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        dfs(root, `val`)
        return answer
    }

    fun dfs(node: TreeNode?, value: Int) {
        if (node == null)
            return
        if(node?.`val` == value) {
            answer = node
            return
        }
        dfs(node.left, value)
        dfs(node.right, value)
    }
}