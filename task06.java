/*	TapeEquilibrium
	Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
	Task Score 100%, Correctness 100%, Performance 100%

	A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
	Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
	The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
	In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

	For example, consider array A such that:

	  A[0] = 3
	  A[1] = 1
	  A[2] = 2
	  A[3] = 4
	  A[4] = 3
	We can split this tape in four places:

	P = 1, difference = |3 − 10| = 7 
	P = 2, difference = |4 − 9| = 5 
	P = 3, difference = |6 − 7| = 1 
	P = 4, difference = |10 − 3| = 7 
	Write a function:

	Assume that:

	N is an integer within the range [2..100,000];
	each element of array A is an integer within the range [−1,000..1,000].
	Complexity:

	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/
	
class Solution {
/*  First we count total sum of the array
    then we increase left part of the array step by step on 1 element
    and equilibrium on this point will be total sum - twice sum of the left part
    (rightSum = total - leftSum; diff = rightSum - leftSum = total - leftSum - leftSum);
    The final answer will be a minimal local equilibrium
*/
    public int solution(int[] A) {
        long totalSum = 0, leftSum = 0, localEqu = 0, minEqu = Integer.MAX_VALUE;
        for (int i : A)
            totalSum += i;
        for (int i = 0; i < A.length; i++) {
            leftSum += A[i];
            localEqu = Math.abs(totalSum - 2 * leftSum);
            if (localEqu < minEqu && i < A.length-1)
                minEqu = localEqu;
        }
        return (int)minEqu;
    }
}