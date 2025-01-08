package com.testing;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

	public static void main(String[] args) {

		int[] arr = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };

		System.out.println(uniqueOccurrences(arr));
	}

	public static boolean uniqueOccurrences(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i : arr) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}

		HashSet<Integer> set = new HashSet<Integer>(map.values());
		if (set.size() == map.values().size()) {
			return true;
		}
		return false;
	}
}
