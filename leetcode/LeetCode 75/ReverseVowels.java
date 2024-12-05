package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		String s = "IceCreAm";

		System.out.println(reverseVowels(s));
	}

	public static String reverseVowels(String s) {
		
        char[] chars = s.toCharArray();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        // Collect all vowels in a list
        List<Character> vowelList = new ArrayList<>();
        for (char c : chars) {
            if (vowels.contains(c)) {
                vowelList.add(c);
            }
        }
       

        // Replace vowels with swapped vowels from the list
        int index = vowelList.size()-1;
        for (int i = 0; i < chars.length; i++) {
            if (vowels.contains(chars[i])) {
                chars[i] = vowelList.get(index--);
            }
        }

        return new String(chars);
	}
}
