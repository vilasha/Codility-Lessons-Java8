/*  A vending machine has the following denominations: 1c, 5c, 10c, 25c, 50c, and $1.
    Your task is to write a program that will be used in a vending machine to return change.
    Assume that the vending machine will always want to return the least number of coins or notes.
    Devise a function getChange(M, P) where M is how much money was inserted into the machine
    and P the price of the item selected, that returns an array of integers representing the number of
    each denomination to return.
    Example:
    getChange(5, 0.99) should return [1,0,0,0,0,4]  */

import java.util.Arrays;
import java.util.Scanner;

public class VendingMachine {

    static int[] getChange(double amount, double purchase) {
        final int[] denominations = {1, 5, 10, 25, 50, 100};
        int[] res = new int[6];
        int change = (int)((amount - purchase) * 100);
        for (int i = 5; i >= 0; i--) {
            res[i] = change / denominations[i];
            change %= denominations[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        double amount = sc.nextDouble();
        double purchase = sc.nextDouble();
        sc.close();
        System.out.println("Change: " + Arrays.toString(getChange(amount, purchase)));
    }
}