package com.testing;

public class Solution {

	public static void main(String[] args) {

		int[] arr = { 3, 8, 9, 15 };
		int k = 2;

		// All subarrays of length 2 are {3, 8}, {8, 9}, {9, 15} and their averages are
		// (3+8)/2 = 5.5, (8+9)/2 = 8.5, and (9+15)/2 = 12.0 respectively.

		// Therefore, the difference between the maximum(=12.0) and minimum(=5.5) is
		// 12.0 -5.5 = 6.5.
		System.out.println(diffOfMaxandMinSubArrys(arr, k));
	}

	// https://builtin.com/data-science/sliding-window-algorithm
	public static float diffOfMaxandMinSubArrys(int[] arr, int k) {

		int n = arr.length;

		if (k > n) {
			return -1;
		}

		float maxSum = Integer.MIN_VALUE;
		float minSum = Integer.MAX_VALUE;

		int windowSum = 0;
		int start = 0;

		for (int i = 0; i < n; i++) {
			windowSum += arr[i];

			if ((i - start + 1) == k) {
				maxSum = Math.max(maxSum, windowSum);
				minSum = Math.min(minSum, windowSum);
				windowSum -= arr[start];
				start++;
			}
		}
		return ((maxSum / 2) - (minSum / 2));
	}
}
