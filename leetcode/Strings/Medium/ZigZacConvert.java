package com.testing;

public class Solution {

	public static void main(String[] args) {

		String s = "PAYPALISHIRING";
		int numRows = 3;

		System.out.println(convert(s,numRows));
	}

	public static String convert(String s, int numRows) {
	
		//[00]P       [04]A	      [08]H       [12]N	
		//[01]A	[03]P [05]L	[07]S [09]I [11]I [13]G
		//[02]Y       [06]I       [10]R  
	
		//For i = 0 => j = 0, 4, 8, 12             => Incrementing by 4  => j + ((2*numRows)-2) * i
		//For i = 1 => j = 1, 3, 5,  7, 09, 11, 13 => Incrementing by 2  => j + ((2*numRows)-2) * i
		//For i = 2 => j = 2, 6, 10 	           => Incrementing by 4  => j + ((2*numRows)-2) * i
		
		if (s == null || s.isEmpty() || numRows <= 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        
        StringBuilder result = new StringBuilder();
        // Step size
        int step = 2 * numRows - 2;
        // Loop for each row
        for (int i = 0; i < numRows; i++) {
            // Loop for each character in the row
            for (int j = i; j < s.length(); j += step) {
                result.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 && (j + step - 2 * i) < s.length()) {
                    result.append(s.charAt(j + step - 2 * i));
                }
            }
        }
        return result.toString();
	}
}
