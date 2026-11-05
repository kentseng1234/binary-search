# Binary Search

A recursive binary search on a sorted array, written for **CSE 2407: Data
Structures and Algorithms** (Washington University in St. Louis).

## What's here

- **`BinarySearch.java`** — a standalone, self-contained version with a small
  `main` demo. Compiles and runs with just a JDK, no external libraries.
- **`src/m3/SearchArrayBinary.java`** — the original studio version, which
  extends a course-provided base class and runs inside a timing harness
  (`timing.*`) to measure operation counts vs. input size. Included for
  reference; it won't compile without the course support libraries.

## The algorithm

Binary search finds a target in a **sorted** array by repeatedly halving the
search interval:

1. Look at the middle element.
2. If it equals the target, done.
3. If the target is smaller, recurse on the left half.
4. If the target is larger, recurse on the right half.
5. If the interval is empty (`low > high`), the target isn't present.

```
search(data, target):
    return binsearch(data, target, 0, data.length - 1)

binsearch(data, target, low, high):
    if low > high:              return -1          # not found
    mid = (low + high) / 2
    if data[mid] == target:     return mid
    if data[mid] >  target:     return binsearch(data, target, low, mid - 1)
    else:                       return binsearch(data, target, mid + 1, high)
```

## Complexity

Each call does O(1) work and makes a single recursive call on half the input,
giving the recurrence:

```
T(n) = 1 * T(n/2) + O(1)   ->   O(log n)
```

| Case  | Time     | When                                  |
|-------|----------|---------------------------------------|
| Best  | O(1)     | target is the first midpoint checked  |
| Worst | O(log n) | target absent, or at an interval edge |

Space is O(log n) from the recursion stack.

**Precondition:** the array must be sorted ascending. On unsorted input the
result is meaningless.

## Running the standalone version

```bash
javac BinarySearch.java
java BinarySearch
```

Expected output:

```
found 22 at index 10
found 2 at index 0
found 37 at index 15
15 not in array
```
