
/**
 *Problem: https://www.hackerrank.com/challenges/java-1d-array/problem
 * 
 **/
import java.util.Scanner;
import java.util.Stack;

import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        return isSolution(leap, game, 0); // You're standing at index 0
    }

    public static boolean isSolution(int leap, int[] game, int i) {
        if (i >= game.length)
            return true; // you can walk or jump off the end of the array and win the game.
        if (i < 0 || game[i] == 1)
            return false; // i < 0 will fall off and you can move from index as long as the destination
                            // index is a cell containing a 0

        game[i] = 1;
        return isSolution(leap, game, i - 1) || isSolution(leap, game, i + 1) || isSolution(leap, game, i + leap);

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
