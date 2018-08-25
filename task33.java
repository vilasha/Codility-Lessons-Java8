/*	MinAbsSum
	Given array of integers, find the lowest absolute sum of elements.
	Task Score 100%, Correctness 100%, Performance 100%

	For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:
	val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|
	(Assume that the sum of zero elements equals zero.)
	For a given array A, we are looking for such a sequence S that minimizes val(A,S).

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.

	For example, given array:
	  A[0] =  1
	  A[1] =  5
	  A[2] =  2
	  A[3] = -2
	your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.

	Assume that:
	N is an integer within the range [0..20,000];
	each element of array A is an integer within the range [−100..100].

	Complexity:
	expected worst-case time complexity is O(N*max(abs(A))2);
	expected worst-case space complexity is O(N+sum(abs(A))) (not counting the storage required for input arguments).	*/

import java.util.Arrays;

class Solution {
    /*  First we find sum of all the elements and
        the biggest/smallest (with max absolute value)
        element. Then for each value of the array we
        calculate its frequency: how many times it appears
        at the array. After that we calculate an array of
        dynamic sum remain*/
    public int solution(int[] A) {
        int sum = 0, maxI = 0;
        for (int i : A) {
            sum += Math.abs(i);
            maxI = Math.max(maxI, Math.abs(i));
        }
        int[] elemFrequency = new int[maxI+1];
        for (int i : A)
            elemFrequency[Math.abs(i)]++;
        int maxSum = 0;
        int[] remain = new int[sum / 2 + 1];
        Arrays.fill(remain, -1);
        for (int i = 1; i <= maxI; i++)
            if (elemFrequency[i] > 0) {
                remain[0] = elemFrequency[i];
                for (int j = 1; j < remain.length; j++)
                    if (remain[j] > -1) {
                        remain[j] = elemFrequency[i];
                        maxSum = Math.max(maxSum, j);
                    } else if (j - i > -1 && remain[j-i] > 0) {
                        remain[j] = remain[j-i] - 1;
                        maxSum = Math.max(maxSum, j);
                    }
            }
        return sum - maxSum * 2;
    }
}