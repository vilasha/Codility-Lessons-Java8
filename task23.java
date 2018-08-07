/*	Dominator
	Find an index of an array such that its value occurs at more than half of indices in the array.
	Task Score 100%, Correctness 100%, Performance 100%

	An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

	For example, consider array A such that
	 A[0] = 3    A[1] = 4    A[2] =  3
	 A[3] = 2    A[4] = 3    A[5] = -1
	 A[6] = 3    A[7] = 3
	The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

	Write a function
	class Solution { public int solution(int[] A); }
	that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

	Assume that:
	N is an integer within the range [0..100,000];
	each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

	Complexity:
	expected worst-case time complexity is O(N);
	expected worst-case space complexity is O(1) (not counting the storage required for input arguments).	*/
	
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
        With the second iteration through the array we just count number
        of occurences of our left behind value  */
    public int solution(int[] A) {
        int n = A.length, size = 0, value = 0;
        for (int i = 0; i < n; i++)
            if (size == 0) {
                size++;
                value = A[i];
            } else
                size += (value == A[i]) ? 1 : -1;
        if (size <= 0)
            return -1;
        int leader = -1, counter = 0;
        for (int i = 0; i < n; i++)
            if (A[i] == value) {
                counter++;
                if (leader == -1)
                    leader = i;
            }
        return (counter > n / 2) ? leader : -1;
    }
}