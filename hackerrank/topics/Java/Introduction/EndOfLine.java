package com.java.hackerrank.dashboard.basics;

import java.util.Scanner;

/**
 * Input Format
 * 
 * Read some unknown n lines of input from stdin(System.in) until you reach EOF;
 * each line of input contains a non-empty String.
 * 
 * Output Format
 * 
 * For each line, print the line number, followed by a single space, and then
 * the line content received as input.
 * 
 **/
public class EndOfLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 1;
		while (sc.hasNext()) {
			System.out.println(i++ + " " + sc.nextLine());
		}
		sc.close();
	}
}
