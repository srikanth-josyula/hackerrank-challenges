import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		String[] pair_left = new String[t];
		String[] pair_right = new String[t];

		for (int i = 0; i < t; i++) {
			pair_left[i] = s.next();
			pair_right[i] = s.next();
		}

		int counter = 0;
		Set<String> name_set = new HashSet<>();
		for (int i = 0; i < t; i++) {
			String name = pair_left[i] + " " + pair_right[i];

			if (name_set.add(name)) {
				counter = counter + 1;
				System.out.println(counter);
			} else {
				System.out.println(counter);
			}

		}

		s.close();
	}
}
