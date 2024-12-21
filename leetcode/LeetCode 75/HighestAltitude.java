package com.sample;

public class Solution {

	public static void main(String[] args) {

		int[] gain = { -5, 1, 5, 0, -7 };

		System.out.println(largestAltitude(gain));
	}

	public static int largestAltitude(int[] gain) {

		int highestAltitude = 0;
		int n = 0;

		// 0, -5 => -5, 1 => -4 , 5 => 1, 0 => 1 ,-7 => -6
		// The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.

		for (int i = 0; i < gain.length; i++) {

			// System.out.println(gain[i]);
			// System.out.println(n + gain[i]);
			n = n + gain[i];

			if (n > highestAltitude) {
				highestAltitude = n;
			}
		}
		// System.out.println(highestAltitude);
		return highestAltitude;
	}
}
