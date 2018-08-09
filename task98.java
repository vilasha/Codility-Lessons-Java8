/*  Given a number X in base -2 as an array A of integers return -X in base -2 represented as array of integers.
	Base -2 means that X = sum{A[i] * (-2)^i}
	Examples:
	1) Given: X=9, input [1, 0, 1, 1]
		 Result: -X=-2, output [1, 1, 0, 1]
	2) Given: X=-23, input [1, 1, 0, 1, 0, 1, 1]
		 Result: -X=23, output [1, 1, 0, 1, 0, 1, 1]    */

import java.util.Arrays;
import java.util.Scanner;

public class Negabinary {
    /*To subtract, multiply each bit of the second number by −1, and add the numbers, using the same table as above.
    Sum	Output	Comment
    Bit	Carry
    −2	010−2	0	1	01−2	−2 occurs only during subtraction.
    −1	011−2	1	1	01−2
    0	000−2	0	0	00−2
    1	001−2	1	0	00−2
    2	110−2	0	−1	11−2
    3	111−2	1	−1	11−2	3 occurs only during addition.
    As an example, to compute 1101001−2 (1 − 8 − 32 + 64 = 25) minus 1110100−2 (4 + 16 − 32 + 64 = 52),
    Carry:          0  1 −1  1  0  0  0
    First number:   1  1  0  1  0  0  1
    Second number: −1 −1 −1  0 −1  0  0 +
                   --------------------
    Number:         0  1 −2  2 −1  0  1
    Bit (result):   0  1  0  0  1  0  1
    Carry:          0  0  1 −1  1  0  0
    so the result is 100101−2 (1 + 4 −32 = −27).
    Unary negation, −x, can be computed as binary subtraction from zero, 0 − x. */

    static int[] unaryNegation(int[] x) {
        int n = x.length;
        int[] res = new int[n+1];
        for (int i = n; i > 0; i--) {
            res[i] -= x[i-1];
            if (res[i] == -1) {
                res[i] = 1;
                res[i-1]++;
            }
        }
        int counter = 0;
        while (res[counter] == 0)
            counter++;
        return Arrays.copyOfRange(res, counter, n+1);
    }

    static int convertToDecimal(int[] negabinary) {
        int result = 0, base = -2, n = negabinary.length;
        for (int i = 0; i < n; i++)
            result += negabinary[i] * Math.pow(base, n-i-1);
        return result;
    }

    static int[] convertToNegaBinary(int value) {
        StringBuilder result = new StringBuilder();
        int base = -2;
        while (value != 0) {
            int remainder = value % base;
            value /= base;
            if (remainder < 0) {
                remainder += 2;
                value++;
            }
            result.insert(0, remainder);
        }
        return result.chars().map(i -> i - '0').toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        int decimal = sc.nextInt();
        sc.close();
        int[] negaBin = convertToNegaBinary(decimal);
        System.out.println("negabin = " + Arrays.toString(negaBin));
        int[] minus = unaryNegation(negaBin);
        System.out.println("minus = " + Arrays.toString(minus));
        int x = convertToDecimal(minus);
        System.out.println("decimal = " + x);
    }
}
