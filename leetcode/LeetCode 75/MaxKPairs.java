package com.testing;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		int[] nums = { 3, 1, 3, 4, 3 };
		int k = 6;

		System.out.println(maxOperations(nums, k));
	}

	public static int maxOperations(int[] nums, int k) {

		int count = 0;
		int left = 0, right = nums.length - 1;

		Arrays.sort(nums);

		while (left < right) {

			int sum = nums[left] + nums[right];
			if (sum == k) {
				count++;
				left++;
				right--;
				// As we already sorted The reason this step is safe is, if arr[left] is giving
				// a smaller value than sum, then it will given even much less values for the
				// elements before arr[right].
			} else if (sum < k) {
				left++;
			} else {
				right--;
			}

		}
		return count;
	}
}
