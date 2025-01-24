package com.testing;

public class Solution {

	public static void main(String[] args) {

		int[] nums = { 3, 5, 2, 1, 7 };
		int k = 2;

		// The subarray [1, 7] is the sum of the maximum sum. i.e 8
		System.out.println(maxSubArraySum(nums, k));
	}

	public static int maxSubArraySum(int[] nums, int k) {
		int maxSum = 0;
		int windowSum = 0;
		int start = 0;

		for (int i = 0; i < nums.length; i++) {
			System.out.println(windowSum);
			windowSum += nums[i];							// i=0; windowSum =3 | i=1; windowSum =3+5 (8)

			if ((i - start + 1) == k) {						// i=1 => 1-0+1 =2 | 
				maxSum = Math.max(maxSum, windowSum);		// Math.max(0,8) = 8
				windowSum -= nums[start];					//windowSum =3+5 (8) -3 (start =0)
				start += 1;
			}
		}
		return maxSum;
	}
}
