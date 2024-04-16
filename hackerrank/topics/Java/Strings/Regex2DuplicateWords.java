package com.java.hackerrank.dashboard.strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In this challenge, we use regular expressions (RegEx) to remove instances of
 * words that are repeated more than once, but retain the first occurrence of
 * any case-insensitive repeated word. For example, the words love and to are
 * repeated in the sentence I love Love to To tO code. Can you complete the code
 * in the editor so it will turn I love Love to To tO code into I love to code?
 * 
 * To solve this challenge, complete the following three lines:
 * 
 * Write a RegEx that will match any repeated word. Complete the second compile
 * argument so that the compiled RegEx is case-insensitive. Write the two
 * necessary arguments for replaceAll such that each repeated word is replaced
 * with the very first instance the word found in the sentence. It must be the
 * exact first occurrence of the word, as the expected output is case-sensitive.
 * Note: This challenge uses a custom checker; you will fail the challenge if
 * you modify anything other than the three locations that the comments direct
 * you to complete. To restore the editor's original stub code, create a new
 * buffer by clicking on the branch icon in the top left of the editor. ###
 * Regex I used this regular expression: "\b(\w+)(?:\W+\1\b)+" When using this
 * regular expression in Java, we have to "escape" the backslash characters with
 * additional backslashes (as done in the code above). \w ----> A word
 * character: [a-zA-Z_0-9] <br/>
 * \W ----> A non-word character: [^\w]<br/>
 * \b ----> A word boundary <br/>
 * \1 ----> Matches whatever was matched in the 1st group of parentheses, which
 * in this case is the (\w+) <br/>
 * + ----> Match whatever it's placed after 1 or more times The \b boundaries
 * are needed for special cases such as "Bob and Andy" (we don't want to match
 * "and" twice). Another special case is "My thesis is great" (we don't want to
 * match "is" twice). ### Groups input = input.replaceAll(m.group(), m.group(1))
 * The line of code above replaces the entire match with the first group in the
 * match. m.group() is the entire match <br/>
 * m.group(i) is the ith match. So m.group(1) is the 1st match (which is
 * enclosed in the 1st set of parentheses) The ?: is added to make it a
 * "non-capturing group" (meaning you can't do .group() to get the group), for
 * slightly faster performance.
 * 
 * 
 **/
public class Regex2DuplicateWords {

	public static void main(String[] args) {

		String regex = "\\b([a-z]+)\\b(?:\\s+\\1\\b)+";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		Scanner in = new Scanner(System.in);
		int numSentences = Integer.parseInt(in.nextLine());

		while (numSentences-- > 0) {
			String input = in.nextLine();
			Matcher m = p.matcher(input);
			// Check for subsequences of input that match the compiled pattern
			while (m.find()) {
				input = input.replaceAll(m.group(), m.group(1));
			}
			// Prints the modified sentence.
			System.out.println(input);
		}

		in.close();
	}
}