https://leetcode.com/problems/count-good-nodes-in-binary-tree/

Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.


Do DFS, save the max value in memory



class Solution {
    var count = 0
    fun goodNodes(root: TreeNode?): Int {
        dfs(root, Int.MIN_VALUE)
        return count
    }

    fun dfs( node: TreeNode?, accMax: Int) {
        if(node == null)
            return

        if (node.`val`>= accMax) {
            count++
        }  

        dfs(node.left, maxOf(node.`val`, accMax))
        dfs(node.right, maxOf(node.`val`, accMax))
 
    }
}

