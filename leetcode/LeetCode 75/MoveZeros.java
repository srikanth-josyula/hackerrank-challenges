package com.testing;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		int[] nums = { 0, 1, 0, 3, 12 };

		moveZeroes(nums);
	}

	public static void moveZeroes(int[] nums) {

		
		//int[] newArry = new int[nums.length];

		int k=0;
		for (int i = 0; i < nums.length; i++) {
			
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[k];
				nums[k] = temp;
				k++;
			}

			/*if (nums[i] != 0 ) {
				newArry[k] = nums[i];
				nums[k] = nums[i];
				k++;
			}*/
		}
		//System.arraycopy(newArry, 0, nums, 0, nums.length);
		System.out.println(Arrays.toString(nums));
	}
}
