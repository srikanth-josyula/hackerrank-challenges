package com.sample;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {

		String pattern = "abba";
		String s = "dog dog dog dog";

		System.out.println(wordPattern(pattern, s));
	}

	public static boolean wordPattern(String pattern, String s) {

		String[] strArr = s.split("\\s");
		HashMap<Character, String> map = new HashMap<Character, String>();

		if (pattern.length() != strArr.length) {
			return false;
		}

		for (int i = 0; i < pattern.length(); i++) {

			// String pattern = "abbc";
			// String s = "dog cat cat dog";

			// first a => dog, we have no a in map, and check we dont have value dog to set to any key, so set to dog 
			// next b => cat, we have no b in map,  and check we dont have value cat to set to any key, so set to cat
			// we have b in map and get values i.e cat and the value in "dog cat cat dog" is cat so move next
			// we dont have c in map but we have dog already mapped to a, so return false

			if (!map.containsKey(pattern.charAt(i))) {
				// Ensure no other character is already mapping to the same word
				if (map.containsValue(strArr[i])) {
					return false; // Word already mapped to another character
				}
				map.put(pattern.charAt(i), strArr[i]);
			} else {
				// If the pattern character is already mapped, ensure the word matches
				if (!map.get(pattern.charAt(i)).equals(strArr[i])) {
					return false;
				}
			}
		}
		return true;
	}
}
