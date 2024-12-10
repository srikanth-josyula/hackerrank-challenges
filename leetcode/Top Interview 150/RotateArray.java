package com.sample;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		int[] nums = { -1, -100, 3, 99 };
		int k = 3;

		rotate(nums, k);
	}

	public static void rotate(int[] nums, int k) {

		int n = nums.length;
		int[] temp = new int[n];

		for (int i = 0; i < n; i++) {
			temp[(i + k) % n] = nums[i];
		}

		System.arraycopy(temp, 0, nums, 0, n);
		System.out.println(Arrays.toString(nums));
	}
}
