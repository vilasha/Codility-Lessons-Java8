/*	GenomicRangeQuery
	Find the minimal nucleotide from a range of sequence DNA.
	Task Score 100%, Correctness 100%, Performance 100%
	
	A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

	The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

	For example, consider string S = CAGCCTA and arrays P, Q such that:
		P[0] = 2    Q[0] = 4
		P[1] = 5    Q[1] = 5
		P[2] = 0    Q[2] = 6
	The answers to these M = 3 queries are as follows:

	The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
	The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
	The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
	Write a function:

	class Solution { public int[] solution(String S, int[] P, int[] Q); }
	that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

	Assume that:
	N is an integer within the range [1..100,000];
	M is an integer within the range [1..50,000];
	each element of arrays P, Q is an integer within the range [0..N − 1];
	P[K] ≤ Q[K], where 0 ≤ K < M;
	string S consists only of upper-case English letters A, C, G, T.

	Complexity:
	expected worst-case time complexity is O(N+M);
	expected worst-case space complexity is O(N) (not counting the storage required for input arguments).	*/
	
class Solution {
    
    /*  We find prefix sums for each value (A, C, G and T)
        while reading string S at the first time. And then for
        each query we find difference of prefix sums, which is
        greater than 0 */
    
    public int[] solution(String S, int[] P, int[] Q) {
        int len = S.length();
        int[][] prefixSums = new int[4][len+1];
        int sumA = 0, sumC = 0, sumG = 0, sumT = 0;
        for (int i = 1; i < len+1; i++) {
            switch (S.charAt(i-1)) {
                case 'A': sumA++; break;
                case 'C': sumC++; break;
                case 'G': sumG++; break;
                case 'T': sumT++; break;
            }
            prefixSums[0][i] = sumA;
            prefixSums[1][i] = sumC;
            prefixSums[2][i] = sumG;
            prefixSums[3][i] = sumT;
        }
        
        int m = Math.min(P.length, Q.length);
        int[] result = new int[m];
        int min, max;
        for (int i = 0; i < m; i++) {
            min = P[i];
            max = Q[i] + 1;
            if (prefixSums[0][max] - prefixSums[0][min] > 0)
                result[i] = 1;
            else if (prefixSums[1][max] - prefixSums[1][min] > 0)
                result[i] = 2;
            else if (prefixSums[2][max] - prefixSums[2][min] > 0)
                result[i] = 3;
            else
                result[i] = 4;
        }
        
        return result;
    }
}