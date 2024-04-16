package com.java.hackerrank.dashboard.strings;

import java.util.Scanner;

/**
 * The first line contains a single string denoting s. 
 * The second line contains two space-separated integers denoting the respective values of start and end.
 **/
public class Substring {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		int start = in.nextInt();
		int end = in.nextInt();
		System.out.println(S.substring(start, end));
		in.close();
	}
}
