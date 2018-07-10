/*  CyclicRotation
	Rotate an array to the right by a given number of steps.
	Task Score 100%, Correctness 100%, Performance 100%

	An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

	The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

	Write a function:

	class Solution { public int[] solution(int[] A, int K); }

	that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

	For example, given

		A = [3, 8, 9, 7, 6]
		K = 3
	the function should return [9, 7, 6, 3, 8]. Three rotations were made:

		[3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
		[6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
		[7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]

	Assume that:

	N and K are integers within the range [0..100];
	each element of array A is an integer within the range [−1,000..1,000].
	In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.	*/
	
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.stream.Collectors;

/* we convert the array to a queue (LinkedList)
   then we pop the last element from the queue and add it
   to the front of the queue. At the end we convert
   the queue back to array */

class Solution {
    
    public int[] solution(int[] A, int K) {
        if (A == null || A.length == 0)
            return A;
        LinkedList<Integer> queue = Arrays.stream(A)
            .boxed().collect(Collectors.toCollection(LinkedList::new));
        while (K-- > 0)
            queue.addFirst(queue.pollLast());
        A = queue.stream().mapToInt(c -> c).toArray();
        return A;
    } 
}