# Sort Algorithms
### Stable vs Unstable Sort Algorithms
Sort algorithms can be divided into two categories: *stable* and *unstable*.

- **Stable Sort Algorithms** preserve the relative order of duplicates; 
- **Unstable Sort Algorithms** however, do not preserve it.

*Stable Sort Algorithms are preferred*. In some cases, such as when sorting primitives, it doesn't
really matter whether you use stable or unstable algorithms, but for when sorting objects it could
make a difference, e.g. when you sort the same array of `Person` twice: first by `name`, then by
`age`. In this case, an unstable sort could produce inconsistent results.

### In-place Sort Algorithms
Another important concept about sort algorithms is whether they are **in-place**. An in-place
algorithm uses only one array and logically partitions it to separate work, usually into *sorted*
and *unsorted* partitions, with the help of auxiliary control variables.

## Bubble Sort: O(n²)
The idea of the algorithm is that it will "bubble up" the big values all the way to the end (or to
the top if you look at it vertically), one-by-one, in a sorted manner.
- *Stable* algorithm.
- In-place algorithm: uses only one array, logically partitioning the array into *sorted* and
  *unsorted*.
- It is however, one of the least time efficient algorithms for sorting. In fact, some courses and
  learning materials may describe it only for reference purposes, given it's implementation should
  be avoided in real software projects.

##### Steps
1. The partitioning is defined by initialising a variable such as `unsortedPartitionIndex`
   containing the value of the last index, given nothing has been sorted yet.
2. A loop starts at index `i = 0` and goes until `unsortedPartitionIndex`:
3. The values of `i` and `i + 1` are compared. If the value of `i` is greater than the value of
   `i + 1`, then the values are swapped, otherwise, nothing happens;
4. At the end of each iteration, `unsortedPartitionIndex` is subtracted by `1`, meaning the sorted
   side of the array is growing on the right side of the index.

## Selection Sort: O(n²)
It is called selection sort because it will select the largest element, and move it to the last
unsorted position of the partition.
- It is an *unstable* algorithm, given there is no guarantee that it won't swap the current
  `largestIndex` value from the iteration with the value of the `lastUnsortedIndex`, as per the
  *Steps* section.
- In-place algorithm: uses only one array, logically partitioning the array into *sorted* and
  *unsorted*, and keeping track of the index of the largest number until the end of each iteration.
- It is slightly more efficient than *Bubble Sort*, given Selection Sort doesn't swap values as
  much. However, if the array is kind of sorted already, the performance difference is very small
  given not many swaps will happen on either algorithms.
  
##### Steps
1. The partitioning is defined by initialising a variable such as `lastUnsortedIndex` containing the
  value of the last index, given nothing has been sorted yet.
2. A loop starts at index `i = 1` and goes until `lastUnsortedIndex`:
3. A variable `largestIndex` is always initialised with the value `0`;
4. The values of `i` and `largestIndex` are compared, if the value of `i` if greater than the value
   of `largestIndex`, then `largestIndex` receives the index `i`.
5. At the end of each iteration, the values of `lastUnsortedIndex` and `largestIndex` are  swapped,
   and `lastUnsortedIndex` is subtracted by `1`.

## Insertion Sort: O(n²)
This algorithm partitions the beginning of the array and inserts the value from the unsorted
partition into the sorted partition in the correct order.

The sorting happens by shifting the values from the unsorted partition to their right until we find
the right place for the new element.

- It is a *stable* algorithm. The values that already sitting at the right order don't get swapped.
- In-place algorithm: uses only one array, logically partitioning the array into *sorted* and
  *unsorted*, and keeping track of the index of the largest number until the end of each iteration.

##### Steps
1. We define the partition by initialising a variable such as `firstUnsortedIndex` with value `1`.
   Whilst the left side of the partition is still an array with a single element, it is fair to say
   that it is sorted.
2. A loop starts at `firstUnsortedIndex` and iterates until the end of the array:
3. A variable `newElement` is assigned the value of `array[firstUnsortedIndex]`.
4. A variable `i` is initialised with the value of the last sorted index, which will be the value of
   `firstUnsortedIndex - 1`;
5. The inner loop goes from the right to the left, comparing the value of `newElement` against
   `array[i]` until the start of the array:
6. If `newElement >= array[i]` then the `newElement` is already at the right place in the sorted
   partition (not on the entire array, but at least at the sorted partition). Otherwise, the value
   of `array[i]` is "shifted to the right", taking over `array[i + 1]`.
7. When the inner loop hits the start of the array, `newElement` is assigned to it since no bigger
   values were found in all the iterations through the sorted partition.

## Shell Sort: O(n²) to O(n log n)
Shell Sort is a variation of Insertion Sort. Instead of always shifting neighbour elements, Shell
Sort starts by doing preliminary work before insertion by shifting elements using a larger gap.
Then, as the algorithm progresses, it reduces the gap until it goes down to 1. At this point, this
algorithm essentially becomes an Insertion Sort.

As in Insertion Sort, the fewer shifts performed, the faster the algorithm runs. Moreover, if the
initial array is kind of already sorted, the algorithm will run at almost `O(n)` complexity.

- *Unstable* algorithm, given it will potentially shift elements far from each other, not
  maintaining the order of duplicated elements relative to each other.
- *In-place* algorithm.
- The name *Shell* comes from *Donald Shell* who published the first version of this sort in 1959.
  It has no relation with shell programming.

##### Gap sequence
This algorithm uses a formula for deciding the gap sequence. Many publications have suggested
different gap sequences, please visit https://en.wikipedia.org/wiki/Shellsort#Gap_sequences for a
list of them.

> The gap sequences can also be applied to *Bubble Sort*, but it will also turn it into an unstable
  algorithm.

##### The Knuth sequence
A common choice of gap sequence is the *Knuth Sequence*, which is calculated by the formula
`(3^k - 1) / 2`, where `k` should be based on the length of the array. The gap should be as close as
possible to the length of the array without being greater than the length of it.
 
The table below shows the first five *gaps* and *k* values of a Knuth sequence:
```
| k | Gap |
|---|-----|
| 1 | 1   |
| 2 | 4   |
| 3 | 13  |
| 4 | 40  |
| 5 | 121 |
```
For an array of length 10, you will want `k = 2` given the gap is `4` and `gap <= 10`. On the other
hand, if you attempt to use `k = 3`, it would yield a gap of `13`, which is bigger than the length,
whereas `k = 1` is too small given we can still safely use `k = 2` as described.
  
##### A simpler sequence
For the sake of abstraction and to remain focused on the sort algorithm, we can use a simpler
sequence where `gap = array.length / 2` rounded down, then, we halve the gap each time until we
reach `1`.
  
## Merge Sort: O(n log n)
- Divide and conquer algorithm
- Recursive algorithm
- Has two phases: splitting (in place logically) and merging (not in-place), where splitting leads
  to faster sorting during the merge phase.
- Since we are using recursive calls to split left and right, the left part of the split will always
  run before the right part.
- *Stable* Algorithm
  
### Splitting
1. Starts with an unsorted array;
2. Divides the array between left and right;
   - Divides in the middle for even lengths, or at the implementation's discretion for odd lengths.
3. Divide both left and right arrays into two arrays each;
4. Keep splitting until all arrays have only one element each - these arrays are sorted.

### Merging
1. Merge every left/right pair of sibling arrays into a sorted array.
2. After the first merge, we will have a bunch of 2-element sorted arrays.
3. Then, merge sort those sorted left/right sibling arrays to end up with a bunch of 4-element
   sorted arrays.
4. Repeat until you have a single sorted array.

#### Merging Implementation
- We create a temporary array large enough to hold all the elements in the arrays we are merging;
- We set `i` to the first index of the left array, and `j` to the first index of the right array,
  where the *index is relative to the original array*.
- If `left[i] <= right[j]`, then `left[i]` is copied to beginning of the temp array, and we
  increment `i` by 1. Otherwise, the same happens to `right[j]` and `j` is incremented by 1.
  
## Quick Sort O(n log n)
- Divide and conquer algorithm
- Recursive algorithm
- In-place algorithm
- Uses a pivot element to partition the array into two logical arrays.
- Elements < pivot go to its left, and elements > pivot go to right, making the pivot to be in its
  sorted position
- The process repeats until the whole array gets partitioned into a series of 1-element arrays, when
  every element has been the pivot, thus being sorted.
- In the worst case, its time complexity is O(n²), O(n log n) on average, but on most cases it
  performs better than Merge Sort.
- Unstable algorithm
  
### Quick Sort Implementation
- We set `start = 0, i = start`, `end = array.length, j = end`, and `pivot = array[start]` to start
  the algorithm;
- Then we look for an element that is less that `pivot` from right to left starting from `--j`, and
  when we find it, we assign it to position `i`;
- Then we look for an element that is greater than the `pivot` from left to right starting at `i++`,
  when we find, similarly, we assign it to the position `j`;
- We stop the algorithm when the pointers cross paths, when `not i < j` anymore;

## Counting Sort O(n)
- Not in-place
- *Unstable* algorithm, but could be made stable with extra steps, for example, by using a
  LinkedList instead of just increasing the count.
- Unlike the previous algorithms, Counting Sort can't sort any type of data with any given value
- Only works with non-negative discrete values (can't work with floats, strings, etc)
- Values must be within a specific small range
- It makes assumptions about the data and don't use comparisons

### Counting Sort Implementation
- We create a new array of integers (count array) of a size which could allocate all possible 
  numbers from the input array. For example, if the input array has 10 numbers of range from 1 to 
  100, then the count array should have size 100.
- Starting at `index = 0`, we iterate through both arrays at the same time;
- For each value of the input array, we increment the "count" on the index of the target array
- At the end of the iteration, the count array will have the count of occurrences of the numbers
  from the input array
- As the last step, we iterate through the count array writing the respective numbers `n` times
  their count back into the input array.