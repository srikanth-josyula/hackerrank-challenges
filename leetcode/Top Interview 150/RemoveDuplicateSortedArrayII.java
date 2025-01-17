package com.testing;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 1, 2, 2, 3 };

		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {

		int k = 2;

        for (int i = 2; i < nums.length; i++) {
        	//System.out.println(Arrays.toString(nums));
        	
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
            
        }
		
		return nums.length;
	}
}
