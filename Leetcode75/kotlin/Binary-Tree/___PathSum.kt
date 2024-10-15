https://leetcode.com/problems/path-sum-iii/



//Failed on Test case
Brute Force: O(nlogn) ~ O(n^2)

class Solution {
    var paths: Int = 0

    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        dfs(root, targetSum)
        return paths
    }

    fun dfs(node: TreeNode?, target: Int) {
        if (node == null){
            return
         }
        check(node, target)
        dfs(node?.left, target)
        dfs(node?.right, target)

    }

    fun check(node: TreeNode?, target: Int) {
         if (node == null) {
            return
         }

        if (node.`val` == target){
            println("$target  ${node.`val`}")
            paths += 1
        }
            
            println("--- ${target - node.`val`}")
        check(node?.left, target-node.`val`)
        check(node?.right, target-node.`val`)
    }
}


Memorization of path sum: O(n)