https://leetcode.com/problems/leaf-similar-trees/

Two binary trees are considered leaf-similar if their leaf value sequence is the same. Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], 
root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true


-------------


class Solution {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
       val leaves1 = mutableListOf<Int>()
       leafNodes(root1, leaves1)
       val leaves2 = mutableListOf<Int>()
       leafNodes(root2, leaves2)

       return leaves1 == leaves2
    }

    fun leafNodes(root: TreeNode?, accum: MutableList<Int>) {
        if(root == null) return
        if(root.left == null && root.right == null) accum += root.`val`
        leafNodes(root.left, accum)
        leafNodes(root.right, accum)
    }
}



------------- My Sol


class Solution {

    val list: ArrayList<Int> = arrayListOf()
    var pos = 0

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {

        // DFS using recursion for 1st tree
        dfs(root1)
        val stack = ArrayDeque<TreeNode?>()
        stack.addLast(root2)

        // DFS using stack for 2nd tree
        while (!stack.isEmpty()) {
            val root2t = stack.removeLast()

            if(root2t?.right != null)
                stack.addLast(root2t?.right)

            if (root2t?.left != null)
                stack.addLast(root2t?.left)


            if (root2t?.left == null && root2t?.right==null) {
                val item = list.getOrNull(pos)
                // if leave size is greater than list size(leave of 1st) OR
                // 1st leave in position is not equal 2nd tree's leave return false
                if (item == null || (item != root2t?.`val`)) {
                    return false
                } 
                pos++
            }
        }

        return if (pos == list.size) {
            true
        } else {
            false
        }
    }

    fun dfs(root: TreeNode?) {
        if (root == null) return
        if (root?.left == null && root?.right==null) {
            println(root?.`val`!!)
            list.add(root?.`val`!!)
        }
        dfs(root?.left)
        dfs(root?.right)
    }
}