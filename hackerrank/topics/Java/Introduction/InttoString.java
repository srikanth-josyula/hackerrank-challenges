package com.java.hackerrank.dashboard.basics;

import java.util.Scanner;

/**
 * TASK
 * 
 * You are given an integer , you have to convert it into a string.
 * 
 * Please complete the partially completed code in the editor. If your code
 * successfully converts into a string the code will print "Good job". Otherwise
 * it will print "Wrong answer".
 * 
 **/

public class InttoString {
	public static void main(String[] args) {

		try {
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			in.close();
			// String s=???; Complete this line below
			String s = n + "";
			// Write your code here

			if (n == Integer.parseInt(s)) {
				System.out.println("Good job");
			} else {
				System.out.println("Wrong answer.");
			}
		} catch (Exception e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}
}
