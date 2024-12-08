package com.sample;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {

		String ransomNote = "bcb";

		String magazine = "cjjajdfaaeegig";

		System.out.println(canConstruct(ransomNote, magazine));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character, Integer> dictionary = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            if (!dictionary.containsKey(c)) {
                dictionary.put(c, 1);
            } else {
                dictionary.put(c, dictionary.get(c) + 1);
            }
        }
        
        for (char c : ransomNote.toCharArray()) {
            if (dictionary.containsKey(c) && dictionary.get(c) > 0) {
                dictionary.put(c, dictionary.get(c) - 1);
            } else {
                return false;
            }
        }
        
        return true;
    }
}
