import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// The first line has an integer n .
		int n = sc.nextInt();
		List<List<Integer>> list = new ArrayList<>(n);

		for (int i = 0; i < n; i++) {
			// In each of the next n lines there will be an integer d
			int d = sc.nextInt();

			List<Integer> l = new ArrayList<>(d);
			for (int j = 0; j < d; j++) {
				int d1 = sc.nextInt();
				l.add(d1);
			}
			list.add(l);
		}
		// In the next line there will be an integer q denoting number of queries.
		int q = sc.nextInt();
		for (int k = 0; k < q; k++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			List<Integer> l = list.get(x - 1);

			if ((y - 1) < l.size()) {
				System.out.println(l.get(y - 1));
			} else {
				System.out.println("ERROR!");
			}
		}
		sc.close();
	}
}
