package com.java.hackerrank.dashboard.basics;

import java.util.Scanner;

/**
 * Task Given an integer,N , print its first 10 multiples. Each multiple N*i
 * should be printed on a new line in the form: N x i = result.
 * 
 **/
public class Loops1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= 10; i++) {
			System.out.println(N + " x " + i + " = " + (N * i));
		}
		sc.close();
	}
}
