https://leetcode.com/problems/maximum-depth-of-binary-tree/


    class Solution {
        fun maxDepth(root: TreeNode?): Int {
            val queue: LinkedList<Pair<TreeNode?, Int>> = LinkedList()
            var tRoot = root
            var depth = 0
            if(root==null)
                return 0
            queue.add(Pair(tRoot, depth))
            while (queue.peek() != null) {
                val item = queue.pop()
                depth = item.second+1
                if (item.first?.left != null) queue.add(Pair(item.first!!.left, depth))
                if (item.first?.right != null) queue.add(Pair(item.first!!.right, depth))
                depth = max(depth, item.second)
            }
            return depth
        }
    }



    Recursion

       class Solution {

        var maxLevel = 0
        
        fun maxDepth(root: TreeNode?): Int {
            dfs(root, 1)
            return maxLevel
        }

        fun dfs(node: TreeNode?, level: Int) {
            if (node == null)
                return
            maxLevel = maxOf(level, maxLevel)    
            dfs(node.left, level+1)   
            dfs(node.right, level+1)    
        }
    }