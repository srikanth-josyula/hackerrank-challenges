package com.sample;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {

		String s = "MCMXCIV";

		romanToInt(s);
	}

	public static int romanToInt(String s) {

		/*Map<Character, Integer> m = new HashMap<>();
		m.put('I', 1);
		m.put('V', 5);
		m.put('X', 10);
		m.put('L', 50);
		m.put('C', 100);
		m.put('D', 500);
		m.put('M', 1000);*/
		
		int[] m = new int[256];  // Array size 256 to cover all possible ASCII characters
        m['I'] = 1;
        m['V'] = 5;
        m['X'] = 10;
        m['L'] = 50;
        m['C'] = 100;
        m['D'] = 500;
        m['M'] = 1000;

		int ans = 0;

		//Using Map ran in 6ms
		/*for (int i = s.length() - 1; i >= 0; i--) {
			if (i > 0 && m.get(s.charAt(i - 1)) < m.get(s.charAt(i))) {
				ans += (m.get(s.charAt(i)) - m.get(s.charAt(i - 1)));
				i--;
			} else {
				ans += (m.get(s.charAt(i)));
			}
		}*/
		
		//Ran in 3ms
		for (int i = s.length() - 1; i >= 0; i--) {
			if (i > 0 && m[s.charAt(i - 1)] < m[s.charAt(i)]) {
				ans += (m[s.charAt(i)] - m[s.charAt(i - 1)]);
				i--;
			} else {
				ans += (m[s.charAt(i)]);
			}
		}
		
		return ans;
	}
}
