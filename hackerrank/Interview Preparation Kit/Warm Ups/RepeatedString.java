import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Result {

	/*
	 * Complete the 'repeatedString' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * following parameters: 1. STRING s 2. LONG_INTEGER n
	 */

	public static long repeatedString(String s, long n) {

		// s=aba
		// n=10

		int length = s.length();
		long countofA = 0;
		// Count the occurrences of 'a' in the original string
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) == 'a')
				countofA++;
		}

		// Calculate the number of complete repetitions of the string 's'
		long repeatCount = n / length; // aba|aba|aba|a (3)

		// Calculate the remaining characters after complete repetitions
		long remainingChars = n % length;// |a (1)

		// Count the occurrences of 'a' in the remaining characters
		long remainingCount = 0;
		for (int i = 0; i < remainingChars; i++) {
			if (s.charAt(i) == 'a')
				remainingCount++; // 1 (a)
		}

		// Total count of 'a's
		long totalCount = countofA * repeatCount + remainingCount; // aba(2)|aba(2)|aba(2) ; 2*3

		return totalCount;
  }
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = bufferedReader.readLine();

		long n = Long.parseLong(bufferedReader.readLine().trim());

		long result = Result.repeatedString(s, n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
