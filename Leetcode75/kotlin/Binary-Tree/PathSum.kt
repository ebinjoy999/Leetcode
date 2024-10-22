https://leetcode.com/problems/path-sum-iii/





------------------------- Using Hash Map
Checking for target path
At each node, we have a currSum, which is the sum of values from the root to the current node.We're interested in checking whether there exists a path that ends at the current node and whose sum equals the target.
currSum - target == some previously seen cumulative sum


Backtracking
After visiting both subtrees, the frequency of the current sum in preSum is decreased by 1 (backtracking), because the function is returning to the previous node and this path should no longer be considered as part of future sums.
preSum.put(currSum, preSum.get(currSum) - 1);

class Solution {
    private var count = 0

    fun pathSum(root: TreeNode?, sum: Int): Int {
        val preSum = HashMap<Int, Int>()
        preSum[0] = 1
        helper(root, 0, sum, preSum)
        return count
    }

    private fun helper(root: TreeNode?, currSum: Int, target: Int, preSum: HashMap<Int, Int>) {
        if (root == null) {
            return
        }

        var currSumVar = currSum + root.`val`

        // Check if there exists a valid path sum
        if (preSum.containsKey(currSumVar - target)) {
            count += preSum[currSumVar - target] ?: 0
        }

        // Add current sum to preSum map
        preSum[currSumVar] = preSum.getOrDefault(currSumVar, 0) + 1

        // Recurse through left and right children
        helper(root.left, currSumVar, target, preSum)
        helper(root.right, currSumVar, target, preSum)

        // Backtrack: Remove current sum from preSum map
        preSum[currSumVar] = preSum[currSumVar]?.minus(1) ?: 0
    }
}



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