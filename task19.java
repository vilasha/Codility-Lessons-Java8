/*	Nesting
	Determine whether a given string of parentheses (single type) is properly nested.
	Task Score 100%, Correctness 100%, Performance 100%
	
	A string S consisting of N characters is called properly nested if:
	S is empty;
	S has the form "(U)" where U is a properly nested string;
	S has the form "VW" where V and W are properly nested strings.

	For example, string "(()(())())" is properly nested but string "())" isn't.

	Write a function:
	class Solution { public int solution(String S); }
	that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

	Assume that:
	N is an integer within the range [0..1,000,000];
	string S consists only of the characters "(" and/or ")".

	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(1) (not counting the storage required for input arguments).	*/
	
class Solution {
    /*  We encode an opening bracket "(" as +1 and closing bracket ")"
        as -1. For a string to be properly nested sum all brackets
        should be 0, and the running sum should never go to minus   */
    public int solution(String S) {
        int n = S.length(), bracketsSum = 0;
        for (int i = 0; i < n; i++) {
            bracketsSum += (S.charAt(i) =='(') ? 1 : -1;
            if (bracketsSum < 0)
                return 0;
        }
        return (bracketsSum == 0) ? 1 : 0;
    }
}