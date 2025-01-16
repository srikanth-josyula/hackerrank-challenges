package com.testing;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		int[] numbers = { 1, 2, 3, 4, 5 };
		int target = 9;

		System.out.println(Arrays.toString(twoSum(numbers, target)));
	}

	public static int[] twoSum(int[] numbers, int target) {

		int len = numbers.length;
		int left = 0;
		int right = len - 1;
		while (left < right) {
			if (numbers[left] + numbers[right] > target) {
				right--;
			} else if (numbers[left] + numbers[right] < target) {
				left++;
			} else {
				return new int[] { left + 1, right + 1 };
			}
		}

		return new int[] { -1, -1 };
	}
}
