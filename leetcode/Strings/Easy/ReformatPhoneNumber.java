package com.sample;

public class Solution {

	public static void main(String[] args) {

		String number = "1-23-4";

		System.out.println(reformatNumber(number));
	}

	public static String reformatNumber(String number) {
	    number = number.replaceAll("\\s", "").replaceAll("-", "");

	    int n = number.length();
	    StringBuilder sb = new StringBuilder();

	    int i = 0;
	    while (n > 0) {
	        if (n > 4) {
	            // Append the next group of 3 digits followed by a hyphen
	        	sb.append(number.substring(i, i + 3)).append("-");
	            i += 3;
	            n -= 3;
	        } else if (n == 4) {
	            // Split into two groups of 2 digits each
	        	sb.append(number.substring(i, i + 2)).append("-").append(number.substring(i + 2, i + 4));
	            break;
	        } else {
	            // Append the remaining 2 or 3 digits directly
	        	sb.append(number.substring(i));
	            break;
	        }
	    }

	    // Remove trailing hyphen if it exists
	    if (sb.charAt(sb.length() - 1) == '-') {
	    	sb.deleteCharAt(sb.length() - 1);
	    }

	    return sb.toString();
	}
}
