/*	Distinct
	Compute number of distinct values in an array.
	Task Score 100%, Correctness 100%, Performance 100%

	Write a function
	class Solution { public int solution(int[] A); }
	that, given an array A consisting of N integers, returns the number of distinct values in array A.

	Assume that:
	N is an integer within the range [0..100,000];
	each element of array A is an integer within the range [−1,000,000..1,000,000].

	Complexity:
	expected worst-case time complexity is O(N*log(N));
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/
	
import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    /*  We convert the array to a set. Sets contain
        only distinct values    */
    public int solution(int[] A) {
        Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());
        return set.size();
    }
}