# Sort Algorithms

## Bubble Sort: O(n²)
- In-place algorithm: uses only one array, logically partitioning the array into *sorted* and
  *unsorted*
- This partitioning is defined by initialising a variable such as `unsortedPartitionIndex`
  containing the value of the last index, given nothing has been sorted yet.
- A loop starts at index `i = 0` and goes until `unsortedPartitionIndex`:
  - The values of `i` and `i + 1` are compared. If the value of `i` is greater than the value of
    `i + 1`, then the values are swapped, otherwise, nothing happens;
  - At the end of each iteration, `unsortedPartitionIndex` is subtracted by `1`, meaning that the
    sorted side of the array is growing on the right side of it.
- The idea of the algorithm is that it will "bubble up" the big values all the way to the end (or to
  the top if you look at it vertically), one-by-one, in a sorted manner.
- However, it is one of the least time efficient algorithms for sorting.