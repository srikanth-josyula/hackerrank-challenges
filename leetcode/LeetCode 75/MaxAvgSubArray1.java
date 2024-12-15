package com.sample;

public class Solution {

	public static void main(String[] args) {

		int[] nums = { 1, 12, -5, -6, 50, 3 };
		int k = 4;

		System.out.println(findMaxAverage(nums, k));
	}

	public static double findMaxAverage(int[] nums, int k) {

		if (nums.length == 1 && k == 1) {
			return nums[0];
		}

		
		double sum = 0.0;
		
		// Initialize the sum of the first 'k' elements
		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}
		
		double avg = (sum/k);
		
		for (int i = k; i < nums.length; i++) {
			//System.out.println(nums[i - k]);
			//System.out.println(nums[i]);
			
			// Slide the window by removing the first element and adding the next
			sum = sum - nums[i - k] + nums[i];
			
			if(sum/k > avg) {
				avg = sum/k;
			}
		}

		return avg;
	}
}
