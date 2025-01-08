package com.testing;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {

		String s = "bbbaaaba", t = "aaabbbba";

		System.out.println(isIsomorphic(s, t));
	}

	public static boolean isIsomorphic(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		int i = 0;
		HashMap<Character, Character> map1 = new HashMap<>();
		//HashMap<Character, Character> map2 = new HashMap<>();

		while (i < s.length() && i < t.length()) {

			if (!map1.containsKey(s.charAt(i)) && !map1.containsValue(t.charAt(i))) {
				map1.put(s.charAt(i), t.charAt(i));
			}

			//if (!map2.containsKey(t.charAt(i)) && !map2.containsValue(s.charAt(i))) {
			//	map2.put(t.charAt(i), s.charAt(i));
			//}
			i++;
		}

		StringBuilder t1 = new StringBuilder();
		for (char c : s.toCharArray()) {
			t1.append(map1.get(c));
		}

		//StringBuilder s1 = new StringBuilder();
		//for (char c : t.toCharArray()) {
		//	s1.append(map2.get(c));
		//}

		// System.out.println(t1.toString() + " == " + t);
		// System.out.println(s1.toString() + " == " + s);

        //if (t1.toString().equals(t) && s1.toString().equals(s)) {
		//	return true;
		//}

		if (t1.toString().equals(t)) {
			return true;
		}

		return false;
   }
}
