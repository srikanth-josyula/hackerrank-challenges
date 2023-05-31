/**
 * Task
 * 
 * In this challenge, you must read an integer, a double, and a String from
 * stdin, There are three lines of output:
 * 
 * On the first line, print String: followed by the unaltered String read from
 * stdin. On the second line, print Double: followed by the unaltered double
 * read from stdin. On the third line, print Int: followed by the unaltered
 * integer read from stdin.
 **/

import java.util.Scanner;

public class StdinAndStdout2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		double d = scanner.nextDouble();
		scanner.nextLine();
		String s = scanner.nextLine();

		System.out.println("String: " + s);
		System.out.println("Double: " + d);
		System.out.println("Int: " + i);

		scanner.close();
	}
}
