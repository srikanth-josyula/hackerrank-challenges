public class Solution {

	public static void main(String[] args) {

		String word1 = "ab", word2 = "pqr";
		System.out.println(mergeAlternately(word1, word2));
	}

	//This took 100ms
	public static String mergeAlternately(String word1, String word2) {

		String output = "";

		char[] ch1 = word1.toCharArray();
		char[] ch2 = word2.toCharArray();

		int limit = 0;
		if (ch1.length > ch2.length) {
			limit = ch1.length;
		} else {
			limit = ch2.length;
		}

		for (int i = 0; i < limit; i++) {

			if (i < ch1.length) {
				output += ch1[i];
			}

			if (i < ch2.length) {
				output += ch2[i];
			}
		}
		return output;
	}

//same code with stringbuilder took 0ms
    public String mergeAlternately(String word1, String word2) {
      
		StringBuilder output = new StringBuilder();

		char[] ch1 = word1.toCharArray();
		char[] ch2 = word2.toCharArray();

		int limit = 0;
		if (ch1.length > ch2.length) {
			limit = ch1.length;
		} else {
			limit = ch2.length;
		}

		for (int i = 0; i < limit; i++) {

			if (i < ch1.length) {
				output.append(ch1[i]);
			}

			if (i < ch2.length) {
				output.append(ch2[i]);
			}
		}
		return output.toString();
	}

}
