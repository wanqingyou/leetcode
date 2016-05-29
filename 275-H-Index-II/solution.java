public class Solution {
    /**
     * Based on the algorithm described in this wikipedia article, when the citations are sorted in descending order, the h-index is the position of the last publication that has citation larger than or equal to its position. Note that the position here starts from 1. Based on the question's information, the input is sorted in ascending order. Then what we need to find is the last element in the array from end to start that satisfies the requirement. Suppose its index is i, and the total number of publications is n, then we need to find the last i from end to start that citations[i] >= n - i. Based on these, we can come up with a natural binary search approach.
     * */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (citations[m] >= n - m) r = m;
            else l = m + 1;
        }
        return citations[l] >= n - l ? n - l : 0;
        }
}