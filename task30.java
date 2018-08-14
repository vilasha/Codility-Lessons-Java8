/*	Peaks
	Divide an array into the maximum number of same-sized blocks, each of which should contain an index P such that A[P - 1] < A[P] > A[P + 1].
	Task Score 100%, Correctness 100%, Performance 100%

	A non-empty array A consisting of N integers is given.
	A peak is an array element which is larger than its neighbors. More precisely, it is an index P such that 0 < P < N − 1,  A[P − 1] < A[P] and A[P] > A[P + 1].

	We want to divide this array into blocks containing the same number of elements. More precisely, we want to choose a number K that will yield the following blocks:
	A[0], A[1], ..., A[K − 1],
	A[K], A[K + 1], ..., A[2K − 1],
	...
	A[N − K], A[N − K + 1], ..., A[N − 1].

	What's more, every block should contain at least one peak. Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be peaks, but only if they have both neighbors (including one in an adjacent blocks).

	The goal is to find the maximum number of blocks into which the array A can be divided.

	Write a function:
	class Solution { public int solution(int[] A); }
	that, given a non-empty array A consisting of N integers, returns the maximum number of blocks into which A can be divided.
	If A cannot be divided into some number of blocks, the function should return 0.

	Assume that:
	N is an integer within the range [1..100,000];
	each element of array A is an integer within the range [0..1,000,000,000].

	Complexity:
	expected worst-case time complexity is O(N*log(log(N)));
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/
	
import java.util.Arrays;

class Solution {
    /*  First we find indexes of peaks.
        Number of slices can't be more than
        number of peaks (each slice should contain
        at least one peak). So we start from number
        of peaks and countdown number of slices until 
        we find a situation when all the slices
        contain at least one peak   */
    public int solution(int[] A) {
        int n = A.length, peaksCount = 0;
        if (n < 3)
            return 0;
        int[] peaks = new int[n];
        for (int i = 1; i < n-1; i++)
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                peaks[peaksCount] = i;
                peaksCount++;
            }
        if (peaksCount == 0)
            return 0;
        peaks = Arrays.copyOfRange(peaks, 0, peaksCount);
        for (int sliceSize = 1; sliceSize < n; sliceSize++) {
            if (n % sliceSize != 0)
                continue;
            int slices = n / sliceSize;
            boolean containsPeaks = true;
            int peakFound = 0;
            for (int peak : peaks)
                if (peak / sliceSize >  peakFound) {
                    containsPeaks = false;
                    break;
                } else if (peak / sliceSize ==  peakFound)
                    peakFound++;
            if (peakFound != slices)
                containsPeaks = false;
            if (containsPeaks)
                return slices;
        }
        return 1;
    }
}