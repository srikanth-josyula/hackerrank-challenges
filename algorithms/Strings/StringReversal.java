import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {

		String str = "hello";

		System.out.println(stringReversal(str));
	}

	public static String stringReversal(String str) {

		String out = "";

		/** Approach - One **/
		StringBuilder sb = new StringBuilder(str);
		// out = sb.reverse().toString();

		/** Approach - Two **/
		// hello ->
		// Step 1 => oellh
		// Step 2 => olleh
		char temp = Character.MIN_VALUE;
		char[] chArry = str.toCharArray();
		int n = chArry.length;
		for (int i = 0; i < n; i++) {
			// System.out.println(i +" = "+str.charAt(i)+" = "+((n-1)-i)+" =
			// "+str.charAt((n-1)-i));
			temp = str.charAt(i);
			chArry[i] = str.charAt((n - 1) - i);
			chArry[(n - 1) - i] = temp;
		}
		// out = String.valueOf(chArry);

		/** Approach - Three **/
		for (int i = str.length() - 1; i >= 0; i--) {
			// out = out + str.charAt(i);
		}

		/** Approach - Four => Using Recursion and Substring **/
		out = reverseUsingRecursion(str);

		/** Approach - Six => Using Stack **/
		Stack<Character> s = new Stack<>();
		for (char c : str.toCharArray()) {
			s.push(c);
		}
		while (!s.isEmpty()) {
			out += s.pop();
		}

		/** Approach - Five => Using ArrayList **/
		ArrayList<Character> list = new ArrayList<Character>();
		for (char c : chArry) {
			list.add(c);
		}
		Collections.reverse(list);
		ListIterator<Character> it = list.listIterator();
		while (it.hasNext()) {
			out += it.next();
		}

		return out;
	}

	public static String reverseUsingRecursion(String str) {
		if (str.length() == 1) {
			return str;
		}
		return str.charAt(str.length() - 1) + reverseUsingRecursion(str.substring(0, str.length() - 1));
	}
}
