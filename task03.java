/*  OddOccurrencesInArray
	Find value that occurs in odd number of elements.
	Task Score 100%, Correctness 100%, Performance 100%
	
	A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

	Write a function:

	class Solution { public int solution(int[] A); }

	that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

	For example, given array A such that:

	  A[0] = 9  A[1] = 3  A[2] = 9
	  A[3] = 3  A[4] = 9  A[5] = 7
	  A[6] = 9
	the function should return 7, as explained in the example above.

	Assume that:

	N is an odd integer within the range [1..1,000,000];
	each element of array A is an integer within the range [1..1,000,000,000];
	all but one of the values in A occur an even number of times.
	Complexity:

	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(1) (not counting the storage required for input arguments).	*/
	
import java.util.Arrays;

class Solution {
    
    /*  We use XOR operation to exclude equal elements and to leave unpaired
        element on its own. For ex., if our sequence is [5, 7, 5]
        5 ^ 7 ^ 5 = (011 ^ 111) ^ 011 = 100 ^ 011 = 111 = 7
        so the result = result ^ A[i]
        But to make the proces quicker (and the program shorter) we use
        IntStream and reduce operation */
    
    public int solution(int[] A) {
        return Arrays.stream(A).reduce(0, (i1, i2) -> i1 ^ i2);
    }
}