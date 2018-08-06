/*	Brackets
	Determine whether a given string of parentheses (multiple types) is properly nested.
	Task Score 100%, Correctness 100%, Performance 100%

	A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
	S is empty;
	S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
	S has the form "VW" where V and W are properly nested strings.

	For example, the string "{[()()]}" is properly nested but "([)()]" is not.

	Write a function:
	class Solution { public int solution(String S); }
	that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

	For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

	Assume that:
	N is an integer within the range [0..200,000];
	string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".

	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/

import java.util.Stack;

class Solution {
    /*  We iterate through the string and save it into a Stack.
        If it is an opening bracket of any type, we just add it
        to the stack. Otherwise we pop the last bracket from
        the stack and compare it to current bracket: they should
        match. At the end of the process our stack should be empty  */
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        int n = S.length(), i;
        char c1, c2;
        for (i = 0; i < n; i++) {
            c1 = S.charAt(i);
            if (c1 == '(' || c1 == '[' || c1 == '{')
                stack.push(c1);
            else {
                if (stack.isEmpty())
                    return 0;
                c2 = stack.pop();
                switch (c2) {
                    case '(': c2 = ')'; break;
                    case '[': c2 = ']'; break;
                    case '{': c2 = '}';
                }
                if (c1 != c2)
                    return 0;
            }
        }
        return (stack.isEmpty()) ? 1 : 0;
    }
}