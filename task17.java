/*	Triangle
	Determine whether a triangle can be built from a given set of edges.
	Task Score 100%, Correctness 100%, Performance 100%

	An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
	A[P] + A[Q] > A[R],
	A[Q] + A[R] > A[P],
	A[R] + A[P] > A[Q].

	For example, consider array A such that:
	  A[0] = 10    A[1] = 2    A[2] = 5
	  A[3] = 1     A[4] = 8    A[5] = 20
	Triplet (0, 2, 4) is triangular.

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

	Assume that:
	N is an integer within the range [0..100,000];
	each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

	Complexity:
	expected worst-case time complexity is O(N*log(N));
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/

import java.util.Arrays;

class Solution {
    /*  First we sort the array.
        A candidate for a triangle should have as little difference
        between length of its edges as possible. So we iterate through
        the array, checking if any 3 consecutive elements satisfy the
        condition of a triangle */
    public int solution(int[] A) {
        Arrays.sort(A);
        int n = A.length-2;
        for (int i = 0; i < n; i++)
            if ((long)A[i] + (long)A[i+1] > (long)A[i+2])
                return 1;
        return 0;
    }
}