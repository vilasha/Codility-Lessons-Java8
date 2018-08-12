/*	MaxDoubleSliceSum
	Find the maximal sum of any double slice.
	Task Score 100%, Correctness 100%, Performance 100%

	A non-empty array A consisting of N integers is given.
	A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
	The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

	For example, array A such that:
		A[0] = 3
		A[1] = 2
		A[2] = 6
		A[3] = -1
		A[4] = 4
		A[5] = 5
		A[6] = -1
		A[7] = 2
	contains the following example double slices:
	double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
	double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
	double slice (3, 4, 5), sum is 0.

	The goal is to find the maximal sum of any double slice.

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.

	Assume that:
	N is an integer within the range [3..100,000];
	each element of array A is an integer within the range [−10,000..10,000].

	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/
	
class Solution {
    /*  We use Kadane's Algorithm in 2 directions:
        forward and reverse */
    public int solution(int[] A) {
        int n = A.length;
        int[] maxSumStart = new int[n];
        int[] maxSumEnd = new int[n];
        for (int i = 1, j = n-2; i < n-1; i++, j--) {
            maxSumEnd[i] = Math.max(0, maxSumEnd[i-1] + A[i]);
            maxSumStart[j] = Math.max(0, maxSumStart[j+1] + A[j]);
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < n-1; i++)
            maxSum = Math.max(maxSum, maxSumEnd[i-1] + maxSumStart[i+1]);
        return maxSum;
    }
}