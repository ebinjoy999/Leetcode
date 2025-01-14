
# Fenwick Tree - Binay Index tree
--------------------------------------

Let P the array contain prefix sum
A = [5, -3, 6, 1, 0]
P = [0, 5 , 2, 8, 9]

sumo of A [1, 4) => P[4] - p[1] => 9-5 =>4
We get i constant time. There is flaw in this if need to update value we need to recompute prefix. So we created Fenwick Tree 

A Fenwick Tree (also called Binary Indexed Tree) is a data structure that supports sum range queries as well as setting values in a static array and getting the value of the prefix sum up some index efficiently.

```
Fenwick Tree: Complexity
Construction 	O(n)
Point Update 	O(log(n))
Range Sum 		O(log(n)) 
Range Update 	O(log(n))
Adding Index 	N/A
Removing Index 	N/A
```

Unlike a regular array, in a Fenwick tree a specific cell is responsible for other cells as well.
The position of the least significant bit (LSB) determines the range of responsibility that cell has to the cells below itself.
For example in 1.png, 
Index 4 in binary is: 00100; LSB is at position 3, so this index is responsible for 2^3-1 = 4 cells below itself. Blue bars A represent the range of responsibility for that cell NOT value.


<img src="1.png" width="60%">
<img src="2.png" width="60%">
-Find prefix sum till index 7 (1.png)
	sum = A[7] + A[6] + A[4] 
- Find prefix sum b/w 11 and 15 (2png)	

Notice that in the worst case the cell we're querying has a binary representation of all ones (numbers of the form 2^n-1)
Hence, it’s easy to see that in the worst case a range query might make us have to do two queries that cost log2(n) operations.

# Fenwick tree point updates

Point Updates
We want to add the LSB to propagate the value up to the cells responsible for us.
```
9 = 1001₂;, 1001₂+0001₂, = 1010₂:
v
10 = 1010₂, 1010₂+0010₂; = 1100₂:
v
12 = 1100₂;, 1100₂+0100₂, = 10000₂:
v
16 = 10000₂
```

### Point update algorithm
To update the cell at index i in the a Fenwick tree of size N:

```
function add(i, x):
	while i < N:
		tree[i] = treel[il + x
		i=1+ LSB(1i)
```
Where LSB returns the value of the least significant bit. 
For example: LSB(12) = 4 

--If we add x to position 6 in the Fenwick tree which cells do we also need to modify?
   So the required updates are we neet to add the position x to 6, 8, 16

<img src="3.png" width="60%">

# Fenwick creation

Arrays should be one-based. This means the first element would have an index of 1. 

Let A be an array of values. For each element in A at index i do a point update
on the Fenwick tree with a value of A[i].
There are n elements and each point update takes 0(log(n)) for a total of 0(nlog(n)), can we do better?

<img src="4.png" width="60%">
Linear construction - 

	If i is the current node and the immediate position above is j, which is given by
	j = i + LSB(i)

```
   Step1: j = 1 + LSB(1) => 0001+0001 =>2 //So we will add pos 2 as value(1)+value(2) => 4+3 =>7
   Step2: j = 2 + LSB(2) => 0010+0010 =>4 //So we will add pos 4 as value(2)+value(4) => 7+7 =>14 (image)
   Step3: j = 3 + LSB(3) => 0011+0001 =>4 //So we will add pos 4 as value(3)+value(4) => -2+14 =>12
   Step4: j = 4 + LSB(4) => 0100+0100 =>8 //So we will add pos 8 as value(4)+value(8) => 12+1-8 =>4
   .......
   Ignore update j if Out of bound 
   ```

Constructed Fenwick tree! We can now perform point and range query updates as required. (5.png)  

Code -  https://github.com/williamfiset/DEPRECATED-data-structures/tree/master/com/williamfiset/datastructures/fenwicktree 
Integer.LowestOneBit(i) // to get LSB

# Construction Algorithm
#Make sure values is 1-based!

	function construct(values):
	N := length(values)
		# Clone the values array since we're
		# doing in place operations
	tree = deepCopy (values)
	for i :=1,2,3, .. N:
		j i= i + LSB(i)
		if j < N:
			treel[j] = treelj] + tree[i]
	return tree