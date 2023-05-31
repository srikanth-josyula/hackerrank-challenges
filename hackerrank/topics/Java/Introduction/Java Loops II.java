/**
 * Task 
 * 
 * We use the integers a, b, and n to create the following series:.
 * (a+2^0*b),(a+2^0*b+2^1*b),(a+2^0*b+2^1*b+2^2*b)....
 * 
 * The first line contains an integer,t , denoting the number of queries
 * Each line i of the t subsequent lines contains three space-separated integers 
 * describing the respective a, b, and n values for that query.
 * 
 * INPUT:
 * 1
 * 5 3 5
 * 
 * OUTPUT:
 * 8 14 26 50 98
 **/

import java.util.Scanner;

public class Loops2 {

	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int i = 0; i < t; i++) {

			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();

			for (int j = 0; j < n; j++) {
				a += (int) (Math.pow(2, j) * b);
				System.out.print(a + " ");
			}
			System.out.println();

		}
		in.close();
	}
}
