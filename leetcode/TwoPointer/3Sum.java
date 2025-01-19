package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		int[] nums = { -1, 0, 1, 2, -1, -4 };
		// [[-1,-1,2],[-1,0,1]]

		System.out.println(threeSum(nums));
	}

	public static List<List<Integer>> threeSum(int[] nums) {

		// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. && solution set must not contain duplicate triplets.

		Set<List<Integer>> result = new HashSet<>();
		int n = nums.length;

		Arrays.sort(nums);
		//System.out.println(Arrays.toString(nums)); //[-4, -1, -1, 0, 1, 2]

		for (int i = 0; i < n - 1; i++) {
			int left = i + 1, right = n - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					
					// Move the `left` pointer and `right` pointer
					left++;
					right--;
				} else if (sum < 0) {
					left++; // Move left pointer to increase sum
				} else {
					right--; // Move right pointer to decrease sum
				}
			}
		}

		return new ArrayList<>(result);
	}
}
