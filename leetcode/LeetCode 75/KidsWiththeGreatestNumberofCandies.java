package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

		int[] candies = { 2, 3, 5, 1, 3 };
		int extraCandies = 3;

		System.out.println(kidsWithCandies(candies, extraCandies));
	}

	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

    // this took 2ms
		//List<Boolean> result = new ArrayList<Boolean>();
		
		int n = candies.length;
    //this took 1ms
		Boolean[] result = new Boolean[n];
		
		int grt = 0;

		for (int candy : candies) {
			if (candy > grt) {
				grt = candy;
			}
		}

		for (int i=0; i<n; i++) {
			if (candies[i] + extraCandies >= grt) {
				result[i] = true;
			} else {
				result[i] = false;
			}
		}
		return Arrays.asList(result);
	}
}
