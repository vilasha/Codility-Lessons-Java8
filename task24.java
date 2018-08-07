/*	EquiLeader
	Find the index S such that the leaders of the sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N - 1] are the same.
	Task Score 100%, Correctness 100%, Performance 100%

	A non-empty array A consisting of N integers is given.
	The leader of this array is the value that occurs in more than half of the elements of A.
	An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

	For example, given array A such that:
		A[0] = 4
		A[1] = 3
		A[2] = 4
		A[3] = 4
		A[4] = 4
		A[5] = 2
	we can find two equi leaders:
	0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
	2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.

	The goal is to count the number of equi leaders.

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

	Assume that:
	N is an integer within the range [1..100,000];
	each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].

	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/
	
class Solution {
	/*  If the leader is contained in more than n/2 elements,
        we can remove pairs of different elements from the array
        and the leader will be left in the array. I.e. in worst case
        the leader element will pair with each of other elements and
        only one leader element will be left behind.
        We could use a stack structure to keep the elements are left
        behind, but since we know that in this stack all the elements
        will be the same value (candidate for the leader), we don't
        actually need to create a stack, we just keep the value of
        the candidate for the leader and number of theese elements in
        our stack.
        With the second iteration through the array we count number
        of occurences of our left behind value 
        With the 3rd iteration we count number of leader element as
        we go through, it will be number of leaders in the left part
        and total leaders minus right side leaders will be left side
        leaders. For a equi leader each side number of leaders should
        be greater than i/2 or (n-i)/2 accordingly.	*/
    public int solution(int[] A) {
        int size = 0, n = A.length, value = 0;
        for (int i = 0; i < n; i++)
            if (size == 0) {
                size++;
                value = A[i];
            } else
				size += (A[i] == value) ? 1 : -1;
        if (size <= 0)
            return 0;
        int counter = 0, leader = 0;
        for (int i = 0; i < n; i++)
            if (A[i] == value)
                counter++;
        if (n - counter >= counter)
            return 0;
		else
			leader = value;

		int leaderInLeftPart = 0, result = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == leader)
                leaderInLeftPart++;
            int leaderInRightPart = counter - leaderInLeftPart;
            if (leaderInLeftPart > (i+1)/2 && leaderInRightPart > (n-i-1)/2)
                result++;
        }
        return result;
    }
}