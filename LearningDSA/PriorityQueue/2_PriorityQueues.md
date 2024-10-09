
# Priority queue 
Priority queue is another version of a queue. However, instead of using FIFO ordering, elements are dequeued in priority order.

Max-priority: The element at the front is always the largest.
Min-priority: The element at the front is always the smallest.

Applications
Dijkstra’s algorithm, shortest pathfinding algorithm, Heap sort, Huffman coding...
Minimum Spanning tree

```
Common operations
interface Queue<T: Any> {
    fun enqueue(element: T): Boolean //add
    fun dequeue(): T?                //poll   
    val count: Int
        get
    val isEmpty: Boolean
        get() = count == 0

    fun peek(): T
}
```
Implementation
You can create a priority queue in the following ways:

1. Sorted array: This is useful to obtain the maximum or minimum value of an element in O(1)
time. However, insertion is slow and requires O(n) because you have to search the right position for every element you insert.

2. Balanced binary search tree: This is useful in creating a double-ended priority queue, which features getting both the minimum and maximum value in O(log n) time. Insertion is better than a sorted array, also in O(log n).

3. Heap: This is a natural choice for a priority queue. A heap is more efficient than a sorted array because a heap only needs to be partially sorted. All heap operations are O(log n) except extracting the min value from a min priority heap is a lightning-fast O(1). Likewise, extracting the max value from a max priority heap is also O(1).



# Heap IMP

```
abstract class AbstractPriorityQueue<T: Any> : Queue<T> {
    // 2
    abstract val heap: Heap<T>
        get
    // more to come ...
}


override fun enqueue(element: T): Boolean {
    heap.insert(element)
    return true
}
override fun dequeue() = heap.remove()

override val count: Int
    get() = heap.count

override fun peek() = heap.peek()


The Heap guarantees to get the one with the highest priority. The overall complexity of dequeue() is the same as remove() : O(log n).
The overall complexity of enqueue() is the same as insert() : O(log n).

"max priority queue" example {
    val priorityQueue = ComparablePriorityQueueImpl<Int>()
    arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach {
        priorityQueue.enqueue(it)
    }
    while (!priorityQueue.isEmpty) {
        println(priorityQueue.dequeue())
    }
}
```

---Example of max priority queue---
```
12
8
7
6
4
3
1
1
```
### Convert min heap to max heap
Suppose lex is a comparator for strings which sorts strings in lexicographic order (the default
in most programming languages). 
Then let nlex be the negation of lex, and also let s1, s2 be strings
```
lex(s1, s2) = -1 if s1 < s2 lexicographically
lex(s1, s2) = 0 if s1 = s2 lexicographically
lex(s1, s2) = +1 if s1 > s2 lexicographically
```


### Complexity of PQ with binary heap
```
Construction: O(n)
Polling:      O(log(n))
Peeking:      O(1)
Adding:       O(log(n))
Naive Removing(Not from root)       O(n)
Advanced Removing (with hash table) O(log(n))
Naive Contains                      O(n)
Contains Check (with hash table)    O(1)
```

### IMPLEMENTATION
* PriorityQueue -> java.util.*
