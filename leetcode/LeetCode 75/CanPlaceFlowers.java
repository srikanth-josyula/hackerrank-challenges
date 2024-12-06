package com.sample;

public class Solution {

	public static void main(String[] args) {

		int[] flowerbed = { 1, 0, 0, 0, 1, 0, 0 };
		int n = 2;

		System.out.println(canPlaceFlowers(flowerbed, n));
	}

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {

		int p = 0;

		for (int i = 0; i < flowerbed.length; i++) {

			if (i == 0 && flowerbed[i] == 0 && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
				p++;
				flowerbed[i] = 1;
			} else if (i > 0 && i < flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i] == 0
					&& flowerbed[i + 1] == 0) {
				p++;
				flowerbed[i] = 1;
			}

			else if (i == flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
				p++;
				flowerbed[i] = 1;
			}
		}
		return n <= p;
	}
}
