package com.sample;

public class Solution {

	public static void main(String[] args) {

		String s = "ab";

		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {

        char[] charArry = s.toCharArray();

        int k = 0;
        int i = 0; // Start i at 0 to handle cases where k and i both begin at the start of the string
        int maxLength = 0;

        if (s.isEmpty()) {
            return 0;
        }
        // Return one if string length is one
        else if (s.length() == 1) {
            return 1;
        }

        while (i < charArry.length) {
            // Update maxLength for the current substring
            if ((i - k) > maxLength) {
                maxLength = (i - k);
            }

            // Check if the character already exists in the current substring
            if (s.substring(k, i).indexOf(charArry[i]) != -1) {
                // Move k to one position after the first occurrence of the duplicate
                k = k + s.substring(k, i).indexOf(charArry[i]) + 1;
            }

            // Increment i to expand the window
            i++;
        }

        // Check maxLength after the loop ends to account for the last valid substring
        if ((i - k) > maxLength) {
            maxLength = (i - k);
        }

        return maxLength;

    /*
        int n = s.length();
        if (n == 0) return 0;

        int maxLength = 0;
        int k = 0; // Start of the current window
        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            // Remove characters from the set until the current character is unique in the window
            while (seen.contains(s.charAt(i))) {
                seen.remove(s.charAt(k));
                k++;
            }
            // Add the current character to the set
            seen.add(s.charAt(i));

            // Update the maximum length of the window
            maxLength = Math.max(maxLength, i - k + 1);
        }

        return maxLength;
    */
  }
}
