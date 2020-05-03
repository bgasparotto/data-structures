# Data Structures and Algorithms
*Data Structures* organise and store data. Different examples are arrays and trees.

*Algorithms* describe the steps you have to perform in order to accomplish a specific task. An example would be a sort algorithm.

## Big-O Notation
- The Big-O notation is a way of expressing the ***time complexity*** of an algorithm related to the
  `n` number of items it has to process:
  - O(1): Constant
  - O(logn): Logarithmic (base 2)
  - O(n): Linear
  - O(nlogn): n log-star n (base 2)
  - O(n²): Quadratic
- When expressing time complexity, always use the worst case scenario. For example, if you have an
  array `[1, 5, 21, -5, 3, 6, 88` and is calculating the time complexity for searching the index of
  the number `21`, the time complexity should be *O(n)* even if we find the number at the third
  iteration.
- It is common for algorithms to contain small optimisations that slightly reduce the number of
  operations related to `n` as the algorithm progresses, however, we are not looking at Big-O
  notation mathematically, what we want instead is an approximation to evaluate how efficient the
  algorithm is.
- A tip to discover the time complexity is to look at how many loops the algorithm has, e.g:
  - 1 loop: O(n)
  - 1 outer loop with an inner loop: O(n²)
  
> The right way of reading the notation is "O of 1, O of log n", etc

> *Binary logarithms* (log n) are the inverse function of the power of two n² function. They are
commonly used in binary search and related algorithms.

The chart below demonstrates the relation of the `n` number of elements against the `N` time needed
by different time complexity expressions:

![Big-O notation time complexity chart](charts/computational_complexity.png)
