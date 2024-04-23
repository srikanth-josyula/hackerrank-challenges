import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<List<Integer>> arr = new ArrayList<List<Integer>>();

		for (int i = 0; i < 6; i++) {
			String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			List<Integer> arrRowItems = new ArrayList<Integer>();

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowTempItems[j]);
				arrRowItems.add(arrItem);
			}
			arr.add(arrRowItems);
		}

		List<Integer> output = new ArrayList<Integer>();
		for (int a = 0; a < (arr.size() - 2); a++) {
			for (int b = 0; b < (arr.get(a).size()) - 2; b++) {
				// System.out.print(arr.get(a).get(b));
				// System.out.print(arr.get(a).get(b + 1));
				// System.out.print(arr.get(a).get(b + 2));
				int firstRow = (arr.get(a).get(b)) + (arr.get(a).get(b + 1)) + (arr.get(a).get(b + 2));

				// System.out.print(arr.get(a + 1).get(b + 1));
				int secondRow = arr.get(a + 1).get(b + 1);

				// System.out.print(arr.get(a + 2).get(b));
				// System.out.print(arr.get(a + 2).get(b + 1));
				// System.out.print(arr.get(a + 2).get(b + 2));
				int thirdRow = ((arr.get(a + 2).get(b)) + (arr.get(a + 2).get(b + 1)) + (arr.get(a + 2).get(b + 2)));

				output.add(firstRow + secondRow + thirdRow);
			}

		}
		Collections.sort(output, Collections.reverseOrder());
		System.out.println(output.get(0));
		bufferedReader.close();
	}
}
