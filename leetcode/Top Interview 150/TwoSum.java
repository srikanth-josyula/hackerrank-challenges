package com.testing;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

	public static void main(String[] args) {

		int[] nums = { 3, 2, 4 };
		int target = 6;

		System.out.println(Arrays.toString(twoSum(nums, target)));
	}

	public static int[] twoSum(int[] nums, int target) {

      Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        // In case there is no solution, return an empty array
        return new int[] {};
      
		/*int[] sol = new int[2];
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					sol[0] = i;
					sol[1] = j;
				}
			}
		}
		return sol; */
	}
}
