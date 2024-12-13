package com.testing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

		int[] nums1 = { 1, 2, 3, 3 };
		int[] nums2 = { 1, 1, 2, 2 };

		System.out.println(findDifference(nums1, nums2));
	}

	public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
      
		// Initialize sets for both arrays
        HashSet<Integer> h1 = new HashSet<>();
        HashSet<Integer> h2 = new HashSet<>();
        
        // Populate the sets
        for (int n : nums1) h1.add(n);
        for (int n : nums2) h2.add(n);
      

        // Remove common elements from both sets
        for (int n : nums2) {
            if (h1.contains(n)) {
                h1.remove(n);
                h2.remove(n);
            }
        }
        
        return List.of(new ArrayList<>(h1),new ArrayList<>(h2));
	}
}
