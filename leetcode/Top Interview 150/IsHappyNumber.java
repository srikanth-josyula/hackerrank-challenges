package com.testing;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		int n = 19;
		System.out.println(isHappy(n));
	}

	public static boolean isHappy(int n) {

		Set<Integer> seen = new HashSet<Integer>();
		
		while(n != 1 && !seen.contains(n)) {
			seen.add(n);
			n = getSum(n);
		}
		
		return n == 1;
	}

	public static int getSum(int n) {
		int sum = 0;
		//Ran in 2ms
		/*for (char c : String.valueOf(n).toCharArray()) {
			sum += (Character.getNumericValue(c) * Character.getNumericValue(c));
		}*/
		
		//Ran in 1ms
		while (n > 0) {
	            int digit = n % 10;
	            sum += digit * digit;
	            n /= 10;
	        }
		
		return sum;
	}
}
