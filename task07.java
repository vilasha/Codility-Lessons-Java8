/*	PermCheck
	Check whether array A is a permutation.
	Task Score 100%, Correctness 100%, Performance 100%
	
	A non-empty array A consisting of N integers is given.
	A permutation is a sequence containing each element from 1 to N once, and only once.
	For example, array A such that:
		A[0] = 4
		A[1] = 1
		A[2] = 3
		A[3] = 2
	is a permutation, but array A such that:
		A[0] = 4
		A[1] = 1
		A[2] = 3
	is not a permutation, because value 2 is missing.

	The goal is to check whether array A is a permutation.
	Write a function:
	class Solution { public int solution(int[] A); }
	that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

	Assume that:
	N is an integer within the range [1..100,000];
	each element of array A is an integer within the range [1..1,000,000,000].

	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).*/
	
class Solution {
    /*  we create an array of counters, the length of this array will be equal
        to the length of the A. Then we iterate through A. If we find an element
        which is less than 1 or more than A.length, it means that the array is not
        a permutation. Otherwise we increase the number of retrospective cell of
        the counter array by 1. If any of the counter values becomes > 1, the array
        is not a permutation once again. Also we remember the maximum value of A
        we met, for a permutation this value should be equal to size of the array
    */
    public int solution(int[] A) {
        int N = A.length;
        int[] counter = new int[N+1];
        int maxValue = 0;
        for (int i : A) {
            if (i < 1 || i > N)
                return 0;
            if (i > maxValue)
                maxValue = i;
            counter[i]++;
            if (counter[i] > 1)
                return 0;
        }
        if (maxValue != N)
            return 0;
        return 1;
    }
}