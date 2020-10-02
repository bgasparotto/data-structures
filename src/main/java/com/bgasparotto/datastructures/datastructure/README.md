# Arrays
* ***Advantages***: Fast for retrieval if you know the index
* ***Disadvantages***: Slow for retrieval (search) if you don't know the index.

- Once created, its size specified during creation (or inferred during initialisation) doesn't
  change.
- Arrays are stored in a contiguous block in memory.
- Every element of an array uses the same amount of memory.
- Arrays are memory efficient because they only store the value with no additional information.
- If an array starts at memory address `x`, and the size of each element in the array is `y`, we can
  calculate the memory address `a` of the `i` ith element by using the expression `a = x + i * y`.
- If we know the index of an element, the time to retrieve the element will be the same, no matter
  where it is in the array.
- That means that if we know the index `i` of an element, arrays are fast for retrieving data.

***Example***: given an array with the start address of `x = 12` in memory, and an element size of `y = 4` bytes, the
formula `a = x + i * y` applies as follows:
```
array = [20, 35, -15, 7, 55, 1, -22]

address of array[0] = 12 + (0 * 4) = 12
address of array[1] = 12 + (1 * 4) = 16
address of array[2] = 12 + (2 * 4) = 20
address of array[3] = 12 + (3 * 4) = 24
address of array[4] = 12 + (4 * 4) = 28
address of array[5] = 12 + (5 * 4) = 32
address of array[6] = 12 + (6 * 4) = 36
```

### Operations
If the operation requires a loop, then the complexity is O(n); if it doesn't require a loop, then
it's O(1).
```
| Operation                                       | Time Complexity |
|-------------------------------------------------|-----------------|
| Retrieve with index                             | O(1)            |
| Retrieve without index (search)                 | O(n)            |
| Add an element to a full array                  | O(n)            |
| Add an element to the end of a not full array   | O(1)            |
| Insert or update an element at a specific index | O(1)            |
| Delete an element by setting it to 0, null, etc | O(1)            |
| Delete an element by shifting elements          | O(n)            |
```

#### Retrieval with index
Time complexity is ***O(1)***:
1. Multiply the size of the element by its index
2. Get the start address of the array
3. Add the start address to the result of the multiplication
```
| # of Elements | Steps |
|---------------|-------|
| 1             | 3     |
| 1000          | 3     |
| 1000000       | 3     |
```

#### Retrieval without index (Search)
Time complexity is ***O(n)***:
1. Loop over the array obtaining each element
2. Compare the element with the wanted value
```
| # of Elements |  Steps  |
|---------------|---------|
| 1             | 2       |
| 1000          | 2000    |
| 1000000       | 2000000 |
```

# Lists
- It's an abstract data type;
- It's an ordered collection (also known as sequence);
- It's good for random access (by index) as the operations are `O(1)`, but additional on a list out
  of capacity or at a specific index, and deletion are `O(n)`.
- The user has control where the element is inserted and can retrieve by its index;
- Popular implementations of List are *ArrayList* and *LinkedList*;
- To implement your own List, either extend `AbstractList` or `AbstractSequentialList`, as they give
  you a head start by providing a skeletal implementation. Read the javadoc of both class to decide
  which one to use.
  
## Vector
- Thread-safe array list, also backed by an array.
- Since its methods are synchronised, there is a performance hit;
- It was introduced at Java 1.0, before the popular ArrayList which was only introduced at Java 1.2;
- If you don't need synchronisation possibly due to using mostly read operations, prefer ArrayList;

## Singly Linked Lists
- The items are called *nodes*;
- The first node is called *head*, as in head of the list;
- Every node, besides carrying its data, carries a reference (link) to the next node;
- The last node is called *tail* always point to `null`, because nothing comes after it;
- The list has only to store the reference of the first node (head);

> *Circular Linked List*
>
> It's a variation of Singly Linked List, where the last node points to the head node, so you can
> transverse the whole list starting at any point.

#### Insertion O(1)
You only insert elements at the front of the list, otherwise you would need to transverse all nodes
until you get to the last node.
1. Create the new node;
2. Assign the current head node as the link of the new node;
3. Assign the new node to the head of the list;

#### Deletion O(1)
You also want to delete from the front of the list, so you don't have to transverse all nodes
1. Obtain the head node;
2. Assign the *next* field of the head node to the List's head node;

## Doubly Linked Lists
- In spite of having a **head** node reference, it also has a **tail**;
- every node in the list has a link to the *next* and *previous* node;
- Operations on either head or tail nodes are O(1);

#### Insertion at head O(1)
1. Create the new node;
2. Assign the current head node as the next of the new node;
3. Assign the previous field of the current head node as the new node;
4. Assign the new node to the head of the list;

#### Insertion at tail O(1)
1. Create the new node;
2. Assign the current tail node as the previous node of the new node;
3. Assign the next field of the current tail node as the new node;
4. Assign the new node to the tail of the list;

#### Deletion from head O(1)
1. Obtain the head node;
2. Assign the *next* field of the head node to the List's head node;
3. Set the *previous* field of the new head node to `null`;

#### Deletion from tail O(1)
1. Obtain the tail node;
2. Assign the *previous* field of the tail node to the List's tail node;
3. Set the *next* field of the new tail node to `null`;

# Stacks
- It's an abstract data type;
- LIFO: Last In, First Out;
- Standard operations are:
  - **Push**: adds an item to the top of the stack;
  - **Pop**: removes the top item of the stack;
  - **Peek**: gets the top item of the stack without popping it
- A *linked list* is the ideal backing data structure for a stack, however, it is possible to 
implement it with any data structure;
- An *array* would be a good choice **if**:
  - You know the maximum number of items the stack will hold;
  - Memory is tight.
- A stack is the perfect data structure for using with a method call stack;

### Stack Operation Costs
```
| Operation |   Linked List   |        Array List        |
|-----------|-----------------|--------------------------|
| Push      | O(1)            | O(1) or O(n) with resize |
| Pop       | O(1)            | O(1)                     |
| Peek      | O(1)            | O(1)                     |
```

# Queues
- It's an abstract data type;
- FIFO: First In, First Out;
- Standard operations are:
  - **Enqueue (Add)**: adds an item to the end of the queue;
  - **Dequeue (Remove)**: removes the item at the front of the queue;
  - **Peek**: gets the item at the front of the queue, without removing it;
- Two popular data structures for implementing queues are *arrays* and *linked lists*
- *Linked list* implementations provide all operations with O(1);
- *Array* implementations, similarly to stack array implementations, provide the operations with 
  O(1) if no resize is needed, O(n) otherwise.

### Queue Operation Costs
```
|     Operation    |   Linked List   |        Array List        |
|------------------|-----------------|--------------------------|
| Enqueue (Add)    | O(1)            | O(1) or O(n) with resize |
| Dequeue (Remove) | O(1)            | O(1)                     |
| Peek             | O(1)            | O(1)                     |
```

# Hashtables (Maps, Dictionaries)
- It's an abstract data type;
- Consists of key/value pairs;
  - Keys could be of any type
  - Values could also be of any type and don't have to match the key types 
- Optimised for retrieval when you know the key
- A common data structure for backing a hashtable is an array, but any structure could be used.
- The key for better performance on a hash table is to provide a good hashing algorithm, which
  distributes the stored values as consistently as possible across the underlying storage structure.

### Hashing
- Keys of any data type are hashed to int by using a hash function;
- In Java, the hash function is `Object.hashCode()`;
- A *collision* is when more than one value has the same hashed value.

### Load Factor
- Tells us how full a hash table is: `f = size / capacity`
- It is used to decide when to resize the array backing the hash table;
- Low load factors leave lots of empty space, whereas high load factors increase the likelihood of 
  collisions;
- Plays a role in determining the time complexity for retrieval.

### Collision Handling Strategies
A collision is when two or more keys hash into the same int value. In order to store these values,
these collisions can be handled with:
  1. **Linear Probing**, which is an *Open Addressing* strategy, where we look for the next 
     available position if the desired position has already been taken.
  2. **Chaining**, where each of the underlying array's position contains a *LinkedList*, so when
     a collision happens, the new element is simply added to the LinkedList at the hashed index.

#### Collision Handling with Linear Probing
- If the hash position has already been taken, we keep adding `1` to the hash value until we find an
  available position or discover the hash table is full.
- Say we had to add `1` three times to the hash, we could say we had to use *three probes*.
- The lower the number of probes, the better.

#### Chaining
- Simpler than linear probing;
- Each linked list at a given index acts similarly to a *bucket*, that keeps elements of the same
  hash.

### Hashtable Operations
#### Put
1. Provide a key/value pair;
2. Use the hash function to hash the key into an int value;
3. If a collision happens, use an underlying algorithm to find a new available key;
4. Store the value at the key hashed value, which is the index of the array.

#### Get
1. Provide the key;
2. Use the same hash function to hash the key into an int value;
3. Lookup for the desired value by comparing the not hashed key starting at the hashed key index.
4. Retrieve the value stored at the hashed key value.

#### Remove
1. Provide the key;
2. Use the same hash function to hash the key into an int value;
3. Set the value stored at the hashed key as null;
4. Rehash the element data storage if linear probing is being used.

### Hashtable Operation Costs
The table below demonstrates the time complexity of the Hashtable operations, when no hash key
collision happens and when they happen and are handled by a specific algorithm.
```
| Operation | No Collision | Linear Probing |   Chaining    |
|-----------|--------------|----------------|---------------|
| Put       | O(1)         | O(n)           | O(1+k) - O(n) |
| Get       | O(1)         | O(n)           | O(1+k) - O(n) |
| Remove    | O(n)         | O(n)           | O(1+k) - O(n) |

k: average length of the linked lists in a chained hash table
```

# Trees
- Trees could be classified as either data structures or abstract data types, since it is possible
  to back a tree using an array. For the sake of the exercise, we will look into them as a data
  structure.
- Tree is a hierarchical data structure.

### Tree's basic terminology:
![Tree example](../../../../../../../images/tree_example.png)

- Every **circle** in a tree is a node;
- Nodes are connected by **edges** (arrows);
- Each node can have *one and only one* **parent**;
- Every tree has the special unique node **root**, which has no parents and is the starting point;
- Each node can have *multiple* **children** nodes;
- A **leaf** is a node with no children;
- The **depth** of a node is the number of *edges* from the node to the root. The depth of the root
  node is always `0`;
- The **height** of a node is the number of *edges* on the *longest path* from the node to a leaf.
  The height of leaf nodes is always `0`;
- The height of a tree is the height of the root node;
- A **level** of a tree contains all the nodes that are on the same *depth*, where `depth == level`;
- An **ancestor** of a node is every node on the node's ascending path, including the root node;
  
### Tree's additional terminology:
- Every tree consists of one or more sub-trees, from the Node of choice descending to its leaves;
- A *singleton tree* has only one node - the root;
- A **path** is a sequence of nodes required to go from one node to another.
- A **root path* is the ascending sequence of how to get from a specific node to the root node;
- You can't have cyclic paths, in other words, a path can't cross the same node more than once;

### Examples of trees:
  - The Java class model, where the root node is the `Object` class;
  - A file system, where the root node is the `/` folder;

### Trees in the JDK:
- `TreeMap`
- `TreeSet`
  
### Complete Binary Tree
A binary tree is **complete** if every level, except the last level, has two children, and at the 
last level all children nodes are as at left as possible:

![Complete Bynary Tree example](../../../../../../../images/complete_binary_tree_example.png) 

### Full Binary Tree
A **full** binary tree is complete and has all last level nodes with both left and right child:

![Full Binary Tree example](../../../../../../../images/full_binary_tree_example.png) 

## Binary Search Trees (BST)
![Binary Search Tree example](../../../../../../../images/binary_search_tree_example.png) 

- In practise, we use binary search trees, which are naturally organised to do binary searches;
- Can perform insertions, deletions and retrievals at *O(log n)*
- Every node has 0, 1 or 2 children;
- We refer to children nodes as left and right child;
- The left child always has a smaller value than its parent;
- The right child always has a larger value than its parent;
- This means everything on the left of the root is less than the root, and everything on the right
  is greater than the root. Because of this, we can perform binary search.
- Handling duplicate values:
  - You can simply don't allow them;
  - You can choose to store them always on the left or always on the right sub-tree;
  - You can have a counter for each node, so instead of adding a new node with the duplicate value, 
    you increase the counter.
- In order to discover the minimum value, you can follow the left path all the way down to the left;
- In order to discover the maximum, follow the right path until the left;

### Insertion
- The first inserted value the root node;
- The following navigate the tree and get inserted at a free spot, follow smaller at left and 
  greater at right rule;
- You *should not* sort data before inserting it into a binary tree, otherwise it will insert
  everything at the same side, emulating a linked list.
- In general, the left and right sub-trees should be as balanced as possible, in other words, their
  height should not differ much.
- Some advanced trees such as AVL and red-black trees would shift sub-trees in order to rebalance
  the trees.

### Traversal
There are four ways of traversing trees:
![Binary Search Tree example](../../../../../../../images/binary_search_tree_example.png) 

**Level**: visit nodes on each level (not used very often):
```
25, 20, 27, 15, 22, 26, 30, 29, 32
```
**Pre-order**: visit the root of every sub-tree first:
```
25, 20, 15, 22, 27, 26, 30, 29, 32
```
**Post-order**: visit the root of every sub-tree last:
```
15, 22, 20, 26, 29, 32, 30, 27, 25
```
**In-order**: visit left child, then root, then right child:
```
15, 20, 22, 25, 26, 27, 29, 30, 32
```

### Deletion
A few deletion scenarios are when:
1. Node is a leaf, then it can be simply removed from the tree;
2. Node has one child, then the child just replaces the node we are deleting;
3. Node has two children, the most complex case, then we should:
   - Find the replacement node;
   - Strive for minimal disruption on the existing tree structure;
   - Take the replacement node from either left or right subtree. Choose one and stick to it;
   - If taking it from the left subtree, we have to take the largest value from it;
   - If taking it from the right subtree, then we take the smallest value;

# Heap
A Heap is a special type of binary tree, of which the following requirements are satisfied:
1. Must be a *complete* binary tree;
2. Must satisfy the heap property, by *either*:
   - *Max heap*: every parent node is greater than of equal to its children, or:
   - *Min heap*: every parent node is less than or equal to its children.
  
- Heaps are usually adopted when you need a data structure that always remove the max or min value 
  from it.
- Children are added at each level from left to right;
- Heaps are usually implemented as arrays;
- The maximum or minimum value will always be at the root of the tree, which is the advantage of
  using a heap;
- *Heapify* is the process of converting a binary tree into a heap. This often has to be done after
  an insertion or deletion;
- There is no required ordering among siblings. The important relation between values is just among
  parents and children.
  
## Heaps as Arrays
![Binary Search Tree example](../../../../../../../images/heap_as_array_example.png)

- We can use an array to back a binary heap;
- We put the *root* at `array[0]`;
- We then store each level of the tree from left to right, so:
  - `array[1]` is the left child of root;
  - `array[2]` is the right child of root;
  - etc;
- To find out the left and right child of a node in `array[i]`:
  - *Left child*: `2i + 1`;
  - *Right child*: `2i + 2`;
  - *Parent*: `floor((i - 1) / 2)`;
  
### Insertion O(log n)
- Always add new items to the end of the array;
- Then we have to fix the heap (heapify):
  1. We compare the new item against its parent:
  2. If the item is greater than its parent (for max heap), we swap them;
  3. Repeat until we compare with the root, or the new value is less than the parent.

### Peek O(1)
- Simply returns the value at `array[0]`, which will always be the max or min value depending on the
  heap type.
  
### Deletion O(log n) from root or O(n log n) for arbitrary values
- Must choose a replacement value;
- Should take the rightmost leaf at `array[n - 1]`, so the tree remains complete;
- Then we heapify the tree again:
  1. We compare the replacement item against the parent;
  2. If the replacement is greater than the parent, then we fix the tree above similarly as insert,
     by swapping the replacement value with the parent;
  3. Otherwise, we fix the heap below, by swapping the replacement value with the larger of its
     two children;
  4. Repeat in either cases until the replacement value is in its correct position.
- Important: you only need to fix up or down, not both.
