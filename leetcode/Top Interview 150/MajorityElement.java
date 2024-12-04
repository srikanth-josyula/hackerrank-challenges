package com.sample;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };

		System.out.println(majorityElement(nums));

	}
	
	//Boyer-Moore Voting Algorithm, which works in O(n) time and O(1) space.

	public static int majorityElement(int[] nums) {

		int count = 0;
		int candidate = 0;

		// Step 1: Find the candidate
		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
		}

		// Step 2: Return the candidate
		return candidate;

	}
}
