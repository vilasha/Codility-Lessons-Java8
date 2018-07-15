/*	PassingCars
	Count the number of passing cars on the road.
	Task Score 100%, Correctness 100%, Performance 100%
	
	A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
	Array A contains only 0s and/or 1s:
	0 represents a car traveling east,
	1 represents a car traveling west.

	The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
	For example, consider array A such that:
	  A[0] = 0
	  A[1] = 1
	  A[2] = 0
	  A[3] = 1
	  A[4] = 1
	We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
	The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.

	Assume that:
	N is an integer within the range [1..100,000];
	each element of array A is an integer that can have one of the following values: 0, 1.

	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(1) (not counting the storage required for input arguments). */
	
class Solution {
    /*  We scan the array from right to left (from the end)
        and if we get a car that travels left (west), we
        increase backwardsCarCount, otherwise we
        increase our main counter with this backwardsCarCount,
        i.e. current right heading car will meet all the
        left heading cars we met before */
    public int solution(int[] A) {
        int counter = 0, backwardsCarCount = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1)
                backwardsCarCount++;
            else
                counter += backwardsCarCount;
            if (counter > 1000000000)
                return -1;
        }
        return counter;
    }
}