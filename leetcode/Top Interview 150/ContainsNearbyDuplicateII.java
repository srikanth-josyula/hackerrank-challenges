package com.testing;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {

		int[] nums = { 1, 0, 1, 1 };
		int k = 1;

		System.out.println(containsNearbyDuplicate(nums, k));
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			} else {
				// System.out.println("Duplicate found for "+nums[i]+" at "+i);
				// System.out.println("Absolute  found for "+nums[i]+" is "+Math.abs(map.get(nums[i])-i));

				if (Math.abs(map.get(nums[i]) - i) <= k) {
					return true;
				} else {
					map.put(nums[i], i);
				}
			}
		}
		return false;
	}
}
