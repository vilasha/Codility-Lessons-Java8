/*	PermMissingElem
	Find the missing element in a given permutation.
	Task Score 100%, Correctness 100%, Performance 100%

	An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

	Your goal is to find that missing element.

	Write a function:

	class Solution { public int solution(int[] A); }

	that, given an array A, returns the value of the missing element.

	For example, given array A such that:

	  A[0] = 2
	  A[1] = 3
	  A[2] = 1
	  A[3] = 5
	the function should return 4, as it is the missing element.

	Assume that:

	N is an integer within the range [0..100,000];
	the elements of A are all distinct;
	each element of array A is an integer within the range [1..(N + 1)].
	Complexity:

	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(1) (not counting the storage required for input arguments).	*/
	
class Solution {
    // First we find a sum of an array without missing element
    // for that we sum first element with last one, second with before-last, etc
    // so if the number of elemenst = N, the sum will be (N + 1) * N / 2
    // Then we substract every element of A from this sum and a difference 
    // will be the missing element
    public int solution(int[] A) {
        long N = A.length + 1;
        long sum = (N + 1) * N / 2;
        for (int i : A)
            sum -= i;
        return (int)sum;
    }
}