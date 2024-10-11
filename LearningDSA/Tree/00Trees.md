
# Tree Class
```
class TreeNode<T>(val value: T) {
	private val children: MutableList<TreeNode<T>> = mutableListOf()
}
```



### DFS
```
fun forEachDepthFirst(visit: Visitor<T>) {
    visit(this)
    children.forEach {
        it.forEachDepthFirst(visit)
    }
}
```

### Level-order traversal
```
fun forEachLevelOrder(visit: Visitor<T>) {
    visit(this)
    val queue = Queue<TreeNode<T>>()
    children.forEach { queue.enqueue(it) }
    var node = queue.dequeue()
    while (node != null) {
        visit(node)
        node.children.forEach { queue.enqueue(it) }
        node = queue.dequeue()
    }
}
```

### create tree
```
fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverages")
    
    val hot = TreeNode("hot")
    val cold = TreeNode("cold")
    
    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")
    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")
    val soda = TreeNode("soda")
    val milk = TreeNode("milk")
    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")
    
    tree.add(hot)
    tree.add(cold)
    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)
    
    cold.add(soda)
    cold.add(milk)
    
    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)
    
    soda.add(gingerAle)
    soda.add(bitterLemon)
    return tree
}
```

# Binary Trees

```
typealias Visitor<T> = (T) -> Unit

class BinaryNode<T: Any>(var value: T) {
	var leftChild: BinaryNode<T>? = null
	var rightChild: BinaryNode<T>? = null
}
```

            A
          /   \
        B       C
       / \     /  \
      D   E   F    G

### In-order traversal
If the current node has a left child, recursively visit this child first.
Then visit the node itself.
If the current node has a right child, recursively visit this child.
D, B, E, A, F, C, G

### Pre-order traversal
Visits the current node first.
Recursively visits the left and right child.
 A, B, D, E, C, F, G 

### Post-order traversal
Recursively visits the left and right child.
Only visits the current node after the left and right child have been visited recursively.
D, E, B, F, G, C, A

### Level Order Traversal (BFS)
A, B, C, D, E, F, G

https://github.com/williamfiset/DEPRECATED-data-structures/blob/master/com/williamfiset/datastructures/binarysearchtree/BinarySearchTree.java
* CHECK remove case
* CHECK 4 type traversal by-return java.util.Iterator<T> 
```
            Eg:   

            private java.util.Iterator<T> preOrderTraversal() {

                final int expectedNodeCount = nodeCount;
                final java.util.Stack<Node> stack = new java.util.Stack<>();
                stack.push(root);

                return new java.util.Iterator<T>() {
                  @Override
                  public boolean hasNext() {
                    if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                    return root != null && !stack.isEmpty();
                  }

                  @Override
                  public T next() {
                    if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                    Node node = stack.pop();
                    if (node.right != null) stack.push(node.right);
                    if (node.left != null) stack.push(node.left);
                    return node.data;
                  }

                  @Override
                  public void remove() {
                    throw new UnsupportedOperationException();
                  }
                };
              }
```

# Binary Search Trees
A binary search tree, or BST, is a data structure that facilitates fast lookup, insert, and removal operations.

A complete binary tree is a tree in which at every level, except possibly the last is
completely filled and and all the nodes are as far left as possible.

Every time the search algorithm visits a node in the BST, it can safely make these two assumptions:
If the search value is less than the current value, it must be in the left subtree.
If the search value is greater than the current value, it must be in the right subtree.

By leveraging the rules of the BST, you can avoid unnecessary checks and cut the search space in half every time you make a decision. That’s why element lookup in a BST is an O(log n) operation.
```
fun insert(value: T) {
    root = insert(root, value)
}

private fun insert(
    node: BinaryNode<T>?,
    value: T
): BinaryNode<T> {
    node ?: return BinaryNode(value)
    if (value < node.value) {
        node.leftChild = insert(node.leftChild, value)
    } else {
        node.rightChild = insert(node.rightChild, value)
    }
    return node
}
```
BST operations
```
Operation   Average    Worst
Insert     O(log(n))   O(n)
Delete     O(log(n))   O(n)
Remove     O(log(n))   O(n)
Search     O(log(n))   O(n)
```
O(n) is worst case so we using balanced BT

# Balanced Binary Search Tree (BBST)

A Balanced Binary Search Tree (BBST) is a self-balancing binary search tree.
This type of tree will adjust itself in order to maintain a low (logarithmic) height allowing for faster operations such as insertions and deletions.

In binary tree if nodes are in a linear fasion the compexity will O(n), so we have balance.

In some BBST implementations where you often need to access the parent/uncle nodes (such as RB trees), it’s convenient for nodes to not only have a reference to the left and the right child nodes but also the parent node. This can complicate tree rotations because instead of updating three pointers, now you have to update six!

https://github.com/williamfiset/DEPRECATED-data-structures/tree/master/com/williamfiset/datastructures/balancedtree

All AVL trees are balanced binary search trees, but not all balanced binary search trees are AVL trees. The AVL tree is just one specific way of balancing a BST, with strict rules on the height difference between subtrees.
n an AVL tree, the height difference between the left and right subtrees of any node is always within -1, 0, or 1.

Non AVL Balance Search tree

         10
        /  \
       5   20
          /  \
        15    30



# AVL Trees


Balance of a binary search tree can impact performance and implement the AVL tree from scratch.

#1 Perfect balance: every level of the tree is filled with nodes from top to bottom.
#2 “Good-enough” balance: balanced tree must have all its levels filled, except for
the bottom one.
#3 Unbalanced: trees in this state suffer from various levels of performance loss depending on the degree of imbalance.

Balance Factor (BF) = Height(Left Subtree) - Height(Right Subtree)


### Unbalanced Node Conditions
Left-heavy: A node with a balance factor greater than 1 is left-heavy.
Right-heavy: A node with a balance factor less than -1 is right-heavy.


If a node becomes unbalanced after an insertion or deletion, the AVL tree must be rebalanced to maintain its properties. Rebalancing typically involves performing rotations (left or right rotations) 

```
*left rotation 
*left-right rotation
*right rotation
*right-left rotation.

```
## Left Rotation
ChatGPT
In an AVL tree, a left rotation is performed when a node becomes imbalanced due to an insertion in the right subtree, causing the balance factor to go out of range (i.e., becoming -2). This rotation helps to restore balance by rotating nodes in such a way that the height difference between the left and right subtrees becomes 1 or 0.

Before Rotation
```
		  X
		/  \
	   A    Y
	   	   / \ 	
		  B   Z
		  	 / \
		  	C   D 	

```
After rotation		  	
```
      Y
     / \
   X     Z
  / \   / \
 A  B  C   D

```

--Left rotation
1)The right child is chosen as the pivot. This node replaces the rotated node as the root of the subtree (it moves up a level).
2)The node to be rotated becomes the left child of the pivot (it moves down a level). This means that the current left child of the pivot must be moved elsewhere.

In the generic example shown in the earlier image, this is node b. Because b is smaller than y but greater than x, it can replace y as the right child of x. So you update the rotated node’s rightChild to the pivot’s leftChild.
3)The pivot’s leftChild can now be set to the rotated node.
4)You update the heights of the rotated node and the pivot.
5)Finally, you return the pivot so that it can replace the rotated node in the tree.

```
private fun leftRotate(node: AVLNode<T>): AVLNode<T> {
	val pivot = node.rightChild!!
	node.rightChild = pivot.leftChild
	pivot.leftChild = node
	node.height = max(node.leftHeight, node.rightHeight) + 1
	pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
	return pivot
}
```

## Right Rotation
A right rotation is performed when a node becomes imbalanced with a left-heavy subtree (balance factor becomes +2). The goal is to move the left child up and rotate the subtree to the right to restore balance.
```
private fun rightRotate(): AVLNode<T>{
	val pivotal = node.leftChild!!
	node.leftChild = pivotal.rightChild
	pivotal.rightChild = node
	node.height = max(node.leftHeight, node.rightHeight) + 1
	pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
	return pivot
}
```
## Right-left rotation

An RL rotation is a double rotation that combines a right rotation on the right child followed by a left rotation on the root. It is needed when the tree becomes right-left heavy, meaning the right child of the root is left-heavy.

    z
     \
      y
     /
    x

      x
     / \
    z   y

--- Balance
```
private fun balanced(node: AVLNode<T>): AVLNode<T> {
    return when (node.balanceFactor) {
        2 -> { 			//left heavier
            if (node.leftChild?.balanceFactor == -1) {
            			//child's balance factor is -1,left subtree is also right-heavy.
                leftRightRotate(node)
            } else {
                rightRotate(node)
            }
        }
        -2 -> { //right heavier
            if (node.rightChild?.balanceFactor == 1) {
                rightLeftRotate(node)
            } else {
                leftRotate(node)
            }
        }
        else -> node
    }
}
```

--Insert
```
private fun insert(node: AVLNode<T>?, value: T): AVLNode<T>? {
    node ?: return AVLNode(value)
    if (value < node.value) {
        node.leftChild = insert(node.leftChild, value)
    } else {
        node.rightChild = insert(node.rightChild, value)
    }
    val balancedNode = balanced(node)
    balancedNode?.height = max(balancedNode?.leftHeight ?: 0,
        balancedNode?.rightHeight ?: 0) + 1
    return balancedNode
}

```

# Tries (try)

Tries are a type of tree data structure that are optimized for efficient string searching. They are often referred to as prefix trees or radix trees.

Root
 |   \
 c    d
 |     \
 a      o
 | \      \
 t   r     g (End of word "dog")
       \
        t (End of word "cart")
(End of word "cat")


A subtree is a tree entirely contained withinanother. They are usually denoted using triangles.
