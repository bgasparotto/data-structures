# Search Algorithms
## Linear Search O(n)
- Simply transverse the entire array checking every element for whether it is the value we are
  looking for;
- If we find the element, we return the index of it in the array, or an invalid index otherwise;
- Better yet is to return an `Optional` as the result, so we avoid the "magic" negative indexes.

## Binary Search O(log n)
- The data must be **sorted** before we can search with binary search;
- If you intend to search an array with binary search, a good idea is to insert the values already
  in a sorted manner;
- Can be implemented either iteratively or recursively;
- Chooses an element in the middle of the array and compares it against the search value:
  - If the elements match, then we are done;
  - If the element is greater than the search value, we search on the left half of the array;
  - If the element is smaller, we search on the right half of the array;
- The algorithm is repeated until:
  - We find the search element, or
  - The search ends by hitting a one-element partition where the element is not the search value;