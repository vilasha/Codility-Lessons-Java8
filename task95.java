/*  Given an array arr[] of size n such that elements
    of arr[] in range [0, 1, ..n-1]. Our task is to
    divide the array into maximum number of partitions
    that can be sorted individually, then concatenated
    to make the whole array sorted. */
	
public class ArrayChunks {

    /*  If an element arr[i] is maximum of prefix arr[0..i],
        then we can make a partition ending with arr[i]*/
		
    static int maxPartitions(int arr[]) {
        int n = arr.length;
        int counterChunks = 0, currentMax = 0;
        for (int i = 0; i < n; ++i) {
            currentMax = Math.max(currentMax, arr[i]);
            if (currentMax == i)
                counterChunks++;
        }
        return counterChunks;
    }

    public static void main (String[] args) {
        int arr[] = { 1, 0, 2, 3, 4 };
        System.out.println (maxPartitions(arr));
    }
}