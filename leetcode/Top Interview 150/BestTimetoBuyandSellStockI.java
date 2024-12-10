package com.sample;

public class Solution {

	public static void main(String[] args) {

		int[] prices = { 7, 1, 5, 3, 6, 4 };

		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {

		int maxProfit = 0;
		int minPrice = prices[0];

		for (int i = 0; i < prices.length; i++) {

			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}

			if (maxProfit < (prices[i] - minPrice)) {
				maxProfit = (prices[i] - minPrice);
				// System.out.println(prices[i] + " - " + minPrice + "=" + maxProfit);
			}

		}
		return maxProfit;
	}
}
