/*	NumberOfDiscIntersections
	Compute the number of intersections in a sequence of discs.
	Task Score 100%, Correctness 100%, Performance 100%
	
	We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

	We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

	Assume that:
	N is an integer within the range [0..100,000];
	each element of array A is an integer within the range [0..2,147,483,647].

	Complexity:
	expected worst-case time complexity is O(N*log(N));
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/
	
import java.util.Arrays;
class Solution {
/*  First we create two arrays of starting points (where a disc intersects
    with x-axe on the left) ane ending points (where a disc intersects with
    x-axe on the right). Then we sort theese arrays, so we don't depend on
    radiuses or centers.
    Then we iterate through both arrays and add intersections of lower end
    and substract already proceeded starting ends to avoid double counting
    intersections
*/
    public int solution(int[] A) {
        long[] A1 = new long[A.length];
        long[] A2 = new long[A.length];
        int i, j = 0, n = A.length;
        for (i = 0; i < n; i++) {
            A1[i] = i - (long)A[i];
            A2[i] = i + (long)A[i];
        }
        Arrays.sort(A1);
        Arrays.sort(A2);
        long intersectCount = 0;
        for (i = 0; i < n; i++)
            while (j < n && A2[i] >= A1[j]) {
                intersectCount += j;
                intersectCount -= i;
                j++;
            }
        if (intersectCount > 10000000)
            intersectCount = -1;
        return (int)intersectCount;
    }
}