/*	StoneWall
	Cover "Manhattan skyline" using the minimum number of rectangles.
	Task Score 100%, Correctness 100%, Performance 100%
	
	You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

	The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

	Write a function:
	class Solution { public int solution(int[] H); }
	that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

	Assume that:
	N is an integer within the range [1..100,000];
	each element of array H is an integer within the range [1..1,000,000,000].

	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/
	
import java.util.Stack;

class Solution {
    /*  We create a stack structure to contain already
        built heights. If current block is taller than
        the previous block or there is no previous block
        at all, we just add current block to the stack and
        increase the counter of used blocks. Otherwise
        we remove top block from the stack until it matches
        our current height  */
    public int solution(int[] H) {
        Stack<Integer> blocks = new Stack<>();
        int blockCounter = 0;
        for (int i = 0; i < H.length; i++) {
            while (!blocks.isEmpty() && blocks.peek() > H[i])
                blocks.pop();
            if (blocks.isEmpty() || blocks.peek() < H[i]) {
                blockCounter++;
                blocks.push(H[i]);
            }
        }
        return blockCounter;
    }
}