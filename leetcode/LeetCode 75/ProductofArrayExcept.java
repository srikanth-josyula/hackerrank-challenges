package com.sample;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4 };

		System.out.println(Arrays.toString(productExceptSelf(nums)))  ;
	}

	public static int[] productExceptSelf(int[] nums) {


		int n = nums.length;
		
		int[] answer = new int[n];
		int[] left = new int[n];
        int[] right = new int[n];
       
		left[0] = 1;

		for (int i = 1; i < n; i++) {
			left[i] = left[i-1] * nums[i-1];
		}
		//System.out.println(Arrays.toString(left));
		
		right[n-1] = 1;
		for (int i = n-2; i >= 0; i--) {
			right[i] = right[i+1] * nums[i+1];
		}
		//System.out.println(Arrays.toString(right));

		for (int i = 0; i < n; i++) {
			answer[i] = right[i] * left[i];
		}
		
		
		/*int k = 0;
		 * while (k < n) {
			int val = 1;
			for (int i = 0; i < n; i++) {
				if (k != i) {
					val = val * nums[i];
				}
			}
			answer[k] = val;
			k++;
		}*/

		return answer;
	}
}
