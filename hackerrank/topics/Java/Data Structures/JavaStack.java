import java.util.Scanner;
import java.util.Stack;

/**
 *Problem: https://www.hackerrank.com/challenges/java-stack/problem 
 * 
 **/
public class Soultion {
	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			while (in.hasNext()) {
				System.out.println(isBalanced(in.next()));
			}
			in.close();
		}

		static boolean isBalanced(String input) {
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (ch == '(' || ch == '[' || ch == '{') {
					stack.push(ch);
				} else if (stack.empty()) {
					return false;
				} else {
					char top = stack.pop();
					if ((top == '(' && ch != ')') || (top == '[' && ch != ']')
							|| (top == '{' && ch != '}')) {
						return false;
					}
				}
			}
			return stack.empty();
		}
}
