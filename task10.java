/*	MaxCounters
	Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.
	Task Score 100%, Correctness 100%, Performance 100%
	
	You are given N counters, initially set to 0, and you have two possible operations on them:
	increase(X) − counter X is increased by 1,
	max counter − all counters are set to the maximum value of any counter.
	A non-empty array A of M integers is given. This array represents consecutive operations:

	if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
	if A[K] = N + 1 then operation K is max counter.
	For example, given integer N = 5 and array A such that:
		A[0] = 3
		A[1] = 4
		A[2] = 4
		A[3] = 6
		A[4] = 1
		A[5] = 4
		A[6] = 4
	the values of the counters after each consecutive operation will be:
		(0, 0, 1, 0, 0)
		(0, 0, 1, 1, 0)
		(0, 0, 1, 2, 0)
		(2, 2, 2, 2, 2)
		(3, 2, 2, 2, 2)
		(3, 2, 2, 3, 2)
		(3, 2, 2, 4, 2)

	The goal is to calculate the value of every counter after all operations.

	Write a function:
	class Solution { public int[] solution(int N, int[] A); }
	that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
	The sequence should be returned as:
	an array of integers (in any other programming language).

	Assume that:
	N and M are integers within the range [1..100,000];
	each element of array A is an integer within the range [1..N + 1].

	Complexity:
	expected worst-case time complexity is O(N+M);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/
	
class Solution {
    /*  The heaviest operation in this algorithm is setting all the counters
        to the maximum value. So we won't do that
        Instead we will keep two values: max, which is actual maximum of the
        array, and adjustMax, which keeps the value of max at the time,
        when last "max counter" operation was called. When we meet an operation
        "increase", we increase by 1 only the values, which are greater than
        adjustMax, otherwise we set the value of X counter to adjustMax+1.
        At the end of iterating A array, we adjust all the counters, which are
        still less than adjustMax (as they were not called by "increase" operation */
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0, adjustMax = 0;
        for (int i : A)
            if (i > N)
                adjustMax = max;
            else {
                i--;
                if (counters[i] < adjustMax)
                    counters[i] = adjustMax + 1;
                else
                    counters[i]++;
                if (max < counters[i])
                    max = counters[i];
            }
        for (int i = 0; i < N; i++)
            if (counters[i] < adjustMax)
                counters[i] = adjustMax;
        return counters;
    }
}