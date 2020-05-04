# Sort Algorithms
*Stable Sort Algorithms* preserve the relative order of duplicates; whereas *Unstable Sort
Algorithms* do not.

*Stable Sort Algorithms* are preferred. In some cases, such as when sorting primitives, it doesn't
really matter, but for when sorting objects it could make a difference, e.g. when you sort the same
array of `Person` twice: first by `name`, then by `age`. In this case, an unstable sort would
produce unreliable results.

## Bubble Sort: O(n²)
- The idea of the algorithm is that it will "bubble up" the big values all the way to the end (or to
  the top if you look at it vertically), one-by-one, in sorted manner.
- In-place algorithm: uses only one array, logically partitioning the array into *sorted* and
  *unsorted*
- The partitioning is defined by initialising a variable such as `unsortedPartitionIndex`
  containing the value of the last index, given nothing has been sorted yet.
- A loop starts at index `i = 0` and goes until `unsortedPartitionIndex`:
  - The values of `i` and `i + 1` are compared. If the value of `i` is greater than the value of
    `i + 1`, then the values are swapped, otherwise, nothing happens;
  - At the end of each iteration, `unsortedPartitionIndex` is subtracted by `1`, meaning that the
    sorted side of the array is growing on the right side of it.
- However, it is one of the least time efficient algorithms for sorting.
- It is a *stable* algorithm.

## Selection Sort: O(n²)
- It is called selection sort because it will select the largest element, and move it to the last
  unsorted position of the partition.
- In-place algorithm: uses only one array, logically partitioning the array into *sorted* and
  *unsorted*, and keeping track of the index of the largest number until the end of each iteration.
- The partitioning is defined by initialising a variable such as `unsortedPartitionIndex`
  containing the value of the last index, given nothing has been sorted yet.
- A loop starts at index `i = 1` and goes until `unsortedPartitionIndex`:
  - A variable `largestIndex` is always initialised with the value `0`;
  - The values of `i` and `largestIndex` are compared, if the value of `i` if greater than the value
    of `i`, then `largestIndex` receives the `i` (not the value, but the index).
  - At the end of each iteration, the values of `unsortedPartitionIndex` and `largestIndex` are
  swapped, and `unsortedPartitionIndex` is subtracted by `1`.
- It is slightly more efficient than *Bubble Sort*, given Selection Sort doesn't swap values as
  much. However, if the array is kind of sorted already, the performance difference is very small,
  given not many swaps will happen on either algorithms.
- It is an *unstable* algorithm, given there is no guarantee that it won't swap the current
  `largestIndex` value from the iteration with the value of the `unsortedPartitionIndex`.
  
## Insertion Sort: O(n²)
- This algorithm partitions the beginning of the array and inserts value from the unsorted partition
  into the sorted partition in sorted manner. That happens by shifting the values from the unsorted
  partition to their right until we find the right place for the new element.
- In-place algorithm: uses only one array, logically partitioning the array into *sorted* and
  *unsorted*, and keeping track of the index of the largest number until the end of each iteration.
- We define the partition by initialising a variable such as `firstUnsortedIndex` with value `1`.
  Since the left side of the partition is still an array with a single element, it is safe to say
  that it is sorted.
- A loop starts at index `firstUnsortedIndex = 1` and goes until the end of the array:
  - A variable `newElement` is assigned the value of `array[firstUnsortedIndex]`.
  - A variable `i` is initialised with the value of the last sorted index, which will be
    `firstUnsortedIndex - 1`;
  - The inner loop goes from the right to the left, comparing the value of `newElement` against
    `array[i]` until the start of the array:
      - If `array[firstUnsortedIndex] >= array[i]` then the `newElement` is already at the right
        place in the sorted partition (not on the entire array, but at least at the sorted
        partition);
      - Otherwise, the value of `array[i]` is "shifted to the right", taking over `array[i + 1]`.
  - When the inner loop hits the start of the array, `newElement` is assigned to it since no bigger
    values were found in all the iterations through the sorted partition.
- It is a *stable* algorithm given values that already sitting at the right order don't get swapped.