/*	MissingInteger
	Find the smallest positive integer that does not occur in a given sequence.
	Task Score 100%, Correctness 100%, Performance 100%
	
	Write a function:
	class Solution { public int solution(int[] A); }
	that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

	For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
	Given A = [1, 2, 3], the function should return 4.
	Given A = [−1, −3], the function should return 1.

	Assume that:
	N is an integer within the range [1..100,000];
	each element of array A is an integer within the range [−1,000,000..1,000,000].

	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments). */
	
class Solution {
    /*  We create an array counter, which keeps how many times a
        value from A appears in it (value of A becomes index of counter)
        We are only interested in positive values which are less then
        N - the size of array. That's why size of counter = N+1, and it
        will be enough. After we fill all the counter's values, we go through
        it and find first 0, which will be the smallest positive missing
        integer. If the counter array is all filled with numbers, it means
        the A array is a permutation, we just return next integer number (N+1) */
    public int solution(int[] A) {
        int N = A.length;
        int[] counter = new int[N+1];
        for (int i : A)
            if (i > 0 && i <= N)
                counter[i]++;
        for (int i = 1; i < N+1; i++)
            if (counter[i] == 0)
                return i;
        return N+1;
    }
}