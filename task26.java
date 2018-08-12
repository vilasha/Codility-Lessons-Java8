/*	MaxSliceSum
	Find a maximum sum of a compact subsequence of array elements.
	Task Score 100%, Correctness 100%, Performance 100%

	A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given an array A consisting of N integers, returns the maximum sum of any slice of A.

	For example, given array A such that:
	A[0] = 3  A[1] = 2  A[2] = -6
	A[3] = 4  A[4] = 0
	the function should return 5 because:
	(3, 4) is a slice of A that has sum 4,
	(2, 2) is a slice of A that has sum −6,
	(0, 1) is a slice of A that has sum 5,
	no other slice of A has sum greater than (0, 1).

	Assume that:
	N is an integer within the range [1..1,000,000];
	each element of array A is an integer within the range [−1,000,000..1,000,000];
	the result will be an integer within the range [−2,147,483,648..2,147,483,647].

	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/
	
class Solution {
    /*  For each position we compute the largest sum, that
        ends at this position. If this sum is less than
        just the current element on its own, we take only
        current element, so all the following sums will start
        from this position. Otherwise we take previously
        calculated sum plus the current element.
        We add 1000001 to start position in case first element
        is negative, so we don't get int overflow   */
    public int solution(int[] A) {
        int currentSum = Integer.MIN_VALUE + 1000001;
        int maxSum = Integer.MIN_VALUE + 1000001;
        for (int a : A) {
            currentSum = Math.max(currentSum + a, a);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}