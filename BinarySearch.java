/**
 * Standalone recursive binary search on a sorted int array.
 *
 * This is a self-contained version of the recursive binsearch I wrote for
 * CSE 2407 (Studio 4). The graded studio version lives in
 * src/m3/SearchArrayBinary.java and runs inside the course timing harness;
 * this file is the same algorithm with a small demo so the repo compiles
 * and runs on its own.
 *
 * Precondition: the array must be sorted ascending.
 * Returns the index of target if found, else -1.
 *
 * Recurrence: T(n) = 1 * T(n/2) + O(1)  ->  O(log n)
 */
public class BinarySearch {

    /** Public entry point: search the whole array. */
    public static int search(int[] data, int target) {
        return binsearch(data, target, 0, data.length - 1);
    }

    /** Recursive search over data[low..high] inclusive. */
    public static int binsearch(int[] data, int target, int low, int high) {
        if (low > high) {
            return -1;                                   // empty interval: not found
        }
        int mid = (low + high) / 2;
        if (data[mid] == target) {
            return mid;                                  // found it
        } else if (data[mid] > target) {
            return binsearch(data, target, low, mid - 1); // search left half
        } else {
            return binsearch(data, target, mid + 1, high); // search right half
        }
    }

    public static void main(String[] args) {
        int[] data = {2, 4, 5, 7, 8, 9, 12, 14, 17, 19, 22, 25, 27, 28, 33, 37};

        int[] targets = {22, 2, 37, 15};   // present, first, last, absent
        for (int t : targets) {
            int idx = search(data, t);
            if (idx >= 0) {
                System.out.println("found " + t + " at index " + idx);
            } else {
                System.out.println(t + " not in array");
            }
        }
    }
}
