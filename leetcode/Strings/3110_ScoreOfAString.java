/**
 * 
 * Input: s = "hello"
 * 
 * Output: 13
 * 
 * Explanation:
 * 
 * The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108,
 * 'o' = 111. So, the score of s would be |104 - 101| + |101 - 108| + |108 -
 * 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.
 *
 */
class Solution {
	public int scoreOfString(String s) {

		int output = 0;
		for (int i = 1; i < s.length(); i++) {
			output += (Math.abs(((int) s.charAt(i - 1)) - ((int) s.charAt(i))));
		}
		return output;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.scoreOfString("hello"));
	}
}
