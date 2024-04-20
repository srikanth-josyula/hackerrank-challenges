package com.java.hackerrank.interviewprepkit.warmups;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * Alex works at a clothing store. There is a large pile of socks that must be
 * paired by color for sale. Given an array of integers representing the color
 * of each sock, determine how many pairs of socks with matching colors there
 * are.
 * 
 * For example, n =7 there are socks with colors ar = [1,2,1,2,1,3,2]. There is
 * one pair of color and one of color . There are 3 odd socks left, one of each
 * color. The number of pairs is 2.
 * 
 * Sample Input 
 * 9 
 * 10 20 20 10 10 30 50 10 20
 * 
 * Sample Output 
 * 3
 **/
public class SalesbyMatch {
	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {

		Set<Integer> hSet = new HashSet<Integer>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int x : ar) {
			boolean flag = hSet.add(x);
			if (flag == true) {
				map.put(x, 1);
			} else {
				map.replace(x, map.get(x) + 1);
			}
		}

		int counter = 0;

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			counter += entry.getValue() / 2;
		}
		
		return counter;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchant(n, ar);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
