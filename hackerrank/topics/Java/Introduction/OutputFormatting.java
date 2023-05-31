package com.java.hackerrank.dashboard.basics;

import java.util.Scanner;

/**
 * TASK
 *
 * Every line of input will contain a String followed by an integer.
 * 
 * In each line of output there should be two columns: The first column contains
 * the String and is left justified using exactly 15 characters. The second
 * column contains the integer, expressed in exactly 3 digits; if the original
 * input has less than three digits, you must pad your output's leading digits
 * with zeroes.
 * 
 * INPUT :
 * 
 * java 100 
 * cpp 65 
 * python 50
 * 
 * OUTPUT :
 * 
 * ================================
 * java           100 
 * cpp            065 
 * python         050 
 * ================================
 **/

public class OutputFormatting {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("================================");
		for (int i = 0; i < 3; i++) {
			String s1 = sc.next();
			int x = sc.nextInt();
			System.out.printf("%-15s%03d\n", s1, x);
		}
		System.out.println("================================");
		sc.close();
	}
}
