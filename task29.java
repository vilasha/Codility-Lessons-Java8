/*	MinPerimeterRectangle
	Find the minimal perimeter of any rectangle whose area equals N.
	Task Score 100%, Correctness 100%, Performance 100%

	An integer N is given, representing the area of some rectangle.
	The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).
	The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

	For example, given integer N = 30, rectangles of area 30 are:
	(1, 30), with a perimeter of 62,
	(2, 15), with a perimeter of 34,
	(3, 10), with a perimeter of 26,
	(5, 6), with a perimeter of 22.

	Write a function:
	class Solution { public int solution(int N); }
	that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

	Assume that:
	N is an integer within the range [1..1,000,000,000].

	Complexity:
	expected worst-case time complexity is O(sqrt(N));
	expected worst-case space complexity is O(1).	*/
	
class Solution {
    /*  The task just comes to finding divisors
        of the N, if the first divisor is i
        and second is j, then the perimeter will be
        (i+j)*2. From geometry more the shape is
        similar to a circle, bigger area it has with
        the same perimeter. I.e. any square has smaller
        perimeter than a rectangle of the same area.
        So we countdown from sqrt(N) until we find
        a first divisor */
    public int solution(int N) {
        int sqrtN = (int)Math.sqrt(N);
        if (sqrtN * sqrtN == N)
            return sqrtN * 4;
        int i = sqrtN;
        while (N % i != 0)
            i--;
        return (i + (N / i) ) * 2;
    }
}