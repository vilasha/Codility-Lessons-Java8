/*	Fish
	N voracious fish are moving along a river. Calculate how many fish are alive.
	Task Score 100%, Correctness 100%, Performance 100%
	
	You are given two non-empty arrays A and B consisting of N integers. Arrays A and B represent N voracious fish in a river, ordered downstream along the flow of the river.

	The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q, then fish P is initially upstream of fish Q. Initially, each fish has a unique position.

	Fish number P is represented by A[P] and B[P]. Array A contains the sizes of the fish. All its elements are unique. Array B contains the directions of the fish. It contains only 0s and/or 1s, where:
	0 represents a fish flowing upstream,
	1 represents a fish flowing downstream.

	If two fish move in opposite directions and there are no other (living) fish between them, they will eventually meet each other. Then only one fish can stay alive − the larger fish eats the smaller one. More precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0, and there are no living fish between them. After they meet:

	If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
	If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.

	We assume that all the fish are flowing at the same speed. That is, fish moving in the same direction never meet. The goal is to calculate the number of fish that will stay alive.

	Write a function:
	class Solution { public int solution(int[] A, int[] B); }
	that, given two non-empty arrays A and B consisting of N integers, returns the number of fish that will stay alive.

	Assume that:
	N is an integer within the range [1..100,000];
	each element of array A is an integer within the range [0..1,000,000,000];
	each element of array B is an integer that can have one of the following values: 0, 1;
	the elements of A are all distinct.

	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/
	
import java.util.Stack;

class Solution {
    /*  We keep all fish that survived in a stack structure (we keep
        just their indexes). Then we go through arrays A and B. If
        our stack is empty, i.e. our current fish is the only live
        fish, we just add it to the stack. The same if the last survived
        fish was moving at the same direction as the current fish:
        they both survive, just move one after another.
        But if the current fish is moving oposite direction and
        its weight is greater then fish from stack, it just eats
        one by one all the fish from the stack until it meets a bigger
        fish or until the stack is empty    */
    public int solution(int[] A, int[] B) {
        Stack<Integer> liveFish = new Stack<>();
        for(int i = 0; i < A.length; i++) {
            if (liveFish.isEmpty())
                liveFish.push(i);
            else {
                while (!liveFish.isEmpty() && B[i]-B[liveFish.peek()] == -1 && A[liveFish.peek()] < A[i])
                    liveFish.pop();
                if (liveFish.isEmpty())
                    liveFish.push(i);
				else if (B[i] - B[liveFish.peek()] != -1)
                    liveFish.push(i);
            }
        }
        return liveFish.size();
    }
}