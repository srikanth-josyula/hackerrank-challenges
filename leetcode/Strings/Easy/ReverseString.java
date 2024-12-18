package com.testing;

public class Solution {

	public static void main(String[] args) {

		char[] s = { 'h', 'e', 'l', 'l', 'o' };

		reverseString(s);
	}

	public static void reverseString(char[] s) {

		//Took 1ms
		/*String str = String.valueOf(s);
		for (int i = 1; i <= s.length; i++) {
			s[i - 1] = str.charAt(s.length - i);
		}
		System.out.println(Arrays.toString(s));*/
		
		//Took 0ms
		int n = s.length;
		for(int i = 0; i < n/2; i++) {
			//System.out.println(i+":"+s[i] +" == "+((n-1)-i)+":"+s[(n-1)-i]);
			//if(i<((n-1)-i)) {
				char ch = s[(n-1)-i];
				 s[(n-1)-i] = s[i];
				 s[i] = ch;
			//}
		}
		//System.out.println(Arrays.toString(s));
	}
}
