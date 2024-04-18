package com.sample;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);

		// n (the initial number of elements in array).
		int n = sc.nextInt();

		// The second line contains n space-separated integers describing array
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}

		// 1 -2 4 -5 1

		int count=0;
		for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if(sum<0) {
                	count++;
                }
            }
        }
		System.out.println(count);
		sc.close();
	}
}
