/*	MinAvgTwoSlice
	Find the minimal average of any slice containing at least two elements.
	Task Score 100%, Correctness 100%, Performance 100%

	A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

	For example, array A such that:
		A[0] = 4
		A[1] = 2
		A[2] = 2
		A[3] = 5
		A[4] = 1
		A[5] = 5
		A[6] = 8
	contains the following example slices:
	slice (1, 2), whose average is (2 + 2) / 2 = 2;
	slice (3, 4), whose average is (5 + 1) / 2 = 3;
	slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.

	The goal is to find the starting position of a slice whose average is minimal.

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

	Assume that:
	N is an integer within the range [2..100,000];
	each element of array A is an integer within the range [−10,000..10,000].

	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/
	
class Solution {
    /*  We find the minimum average of slices size 2 and slice 3.
        Bigger slices always will have greater average. Most of the
        cases will have minimum average in a slice of 2 (arrays like
        1, 2, 3, 4, etc). Some will have smaller average in a slice of
        three (arrays like 1 4 1 7) */
    public int solution(int[] A) {
        double minAvg = (double)(A[0] + A[1]) / 2.0;
        int minAvgIndex = 0;
        int n = A.length;
        for (int i = 0; i < n-1; i++) {
            if ((double)(A[i] + A[i+1]) / 2.0 < minAvg) {
                minAvg = (double)(A[i] + A[i+1]) / 2.0;
                minAvgIndex = i;
            }
            if (i < n-2 && (double)(A[i] + A[i+1] + A[i+2]) / 3.0 < minAvg) {
                minAvg = (double)(A[i] + A[i+1] + A[i+2]) / 3.0;
                minAvgIndex = i;
            }
        }
        return minAvgIndex;
    }
}