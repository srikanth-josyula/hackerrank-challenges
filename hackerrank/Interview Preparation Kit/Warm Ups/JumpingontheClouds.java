package com.java.hackerrank.interviewprepkit.warmups;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Emma is playing a new mobile game involving n clouds numbered from 0 to n-1 .
 * A player initially starts out on cloud c0, and they must jump to cloud
 * c(n-1). In each step, she can jump from any cloud i to cloud i+1 or cloud i +
 * 2. There are two types of clouds, ordinary clouds and thunderclouds. The game
 * ends if Emma jumps onto a thundercloud, but if she reaches the last cloud
 * (i.e., c(n-1)), she wins the game! Can you find the minimum number of jumps
 * Emma must make to win the game? It is guaranteed that clouds c0 and c(n-1)
 * are ordinary-clouds and it is always possible to win the game.
 * 
 * Sample Input 6 0 0 0 0 1 0
 * 
 * Sample Output 3
 **/
public class JumpingontheClouds {

	// Check the i + 2 th cloud. If it is 0 then jump to the i + 2 th cloud else
	// jump to the i + 1 th cloud.
	// Count the jumps in both the cases
	
	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int i = 0;
		int count = 0;

		while (i + 2 <= c.length) {
			if (i + 2 == c.length) {
				if (c[i + 1] == 0) {
					i += 1;
					count++;
				} else {
					break;
				}
			} else {
				i += (c[i + 2] == 0) ? 2 : 1;
				count++;
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
