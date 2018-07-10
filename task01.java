/*  BinaryGap
	Find longest sequence of zeros in binary representation of an integer.
	Task Score 100%, Correctness 100%, Performance 100%

	A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

	For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

	Write a function:

	class Solution { public int solution(int N); }

	that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

	For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

	Assume that:

	N is an integer within the range [1..2,147,483,647].
	Complexity:

	expected worst-case time complexity is O(log(N));
	expected worst-case space complexity is O(1).	*/
	
import java.util.stream.*;

class Solution {
    public int solution(int N) {
                // get binary representation of the N
        return Stream.of(Integer.toBinaryString(N)
                // trim "0"s at the end of the string
            .replaceAll("0+$", "")
                // split with "1"s
            .split("1+"))
                // exclude null elements
            .filter(i -> i != null)
                // for each binary gap replace it with its length
            .map(String::length)
                // find the longest gap
            .max(Integer::compare)
                // or return 0 if there was no gaps
            .orElse(0);
    }
}