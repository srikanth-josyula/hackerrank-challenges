package com.java.hackerrank.dashboard.basics;

import java.util.Scanner;

/**
 * Static initialization blocks are executed when the class is loaded, and you can initialize static variables in those blocks. 
 * 
 * There are two lines of input. 
 * The first line contains : the breadth of the parallelogram. 
 * The next line contains : the height of the parallelogram
 * 
 * OUTPUT:
 * 
 * If both values are greater than zero, then the main method must output the area of the parallelogram. 
 * Otherwise, print "java.lang.Exception: Breadth and height must be positive" without quotes.
 **/
public class StaticInitializerBlock {
	// Code for submission start
	static Scanner sc = new Scanner(System.in);
	static int B = sc.nextInt();
	static int H = sc.nextInt();
	static boolean flag;
	static {
		try {
			if (B > 0 && H > 0) {
				flag = true;
			} else {
				throw new Exception("Breadth and height must be positive");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// Code for submission end
	public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main
}
