package com.java.hackerrank.dashboard.basics;

import java.util.Scanner;

/**
 * Task
 * 
 * In this challenge, you must read integers from stdin and then print them to
 * stdout. Each integer must be printed on a new line. To make the problem a
 * little easier, a portion of the code is provided for you in the editor below.
 **/
public class StdinAndStdout {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();

		scanner.close();

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
