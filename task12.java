/*	CountDiv
	Compute number of integers divisible by k in range [a..b].
	Task Score 100%, Correctness 100%, Performance 100%
	
	Write a function:
	class Solution { public int solution(int A, int B, int K); }
	that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
	{ i : A ≤ i ≤ B, i mod K = 0 }
	For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

	Assume that:
	A and B are integers within the range [0..2,000,000,000];
	K is an integer within the range [1..2,000,000,000];
	A ≤ B.

	Complexity:
	expected worst-case time complexity is O(1);
	expected worst-case space complexity is O(1).	*/
	
class Solution {
    /*  The number of integers divisible by K from 0 to B is (int)B/K
        and we substract number of integers divisible by K from 0 to A.
		As our interval is inclusive, so we substract number of divisibles
		not up to A, but up to A-1.
        The only exception is when B or A equals to 0, in this case
        number of divisibles in corresponding interval is 1, not 0 */
    public int solution(int A, int B, int K) {
        if (B == 0)
            return 1;
        return (B / K) - ((A == 0) ? -1 : (A - 1) / K);
    }
}