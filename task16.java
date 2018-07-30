/*	MaxProductOfThree
	Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).
	Task Score 100%, Correctness 100%, Performance 100%

	A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
	Your goal is to find the maximal product of any triplet.

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given a non-empty array A, returns the value of the maximal product of any triplet.

	Assume that:
	N is an integer within the range [3..100,000];
	each element of array A is an integer within the range [−1,000..1,000].

	Complexity:
	expected worst-case time complexity is O(N*log(N));
	expected worst-case space complexity is O(1) (not counting the storage required for input arguments).	*/
	
import java.util.Arrays;

class Solution {
    /*  First we sort the array with a built-in function "sort",
        then the maximum product of triplet will be either
        product of three biggest elements or product of
        two smallest elements (if they both are negative, their
        multiplication will be positive) multiplied by the biggest
        element (if it is positive) */
    public int solution(int[] A) {
        Arrays.sort(A);
        int n = A.length - 1;
        return Math.max(A[n-2] * A[n-1] * A[n],
                        A[0] * A[1] * A[n]);
    }
}