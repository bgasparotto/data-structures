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
  
# Vector
- Thread-safe array list, also backed by an array.
- Since its methods are synchronised, there is a performance hit;
- It was introduced at Java 1.0, before the popular ArrayList which was only introduced at Java 1.2;
- If you don't need synchronisation possibly due to using mostly read operations, prefer ArrayList;

