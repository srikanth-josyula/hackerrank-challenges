import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		Map<String, Integer> person = new HashMap<>(n);
		for (int i = 0; i < n; i++) {
			String name = sc.nextLine();
			int phone = sc.nextInt();
			person.put(name, phone);
			sc.nextLine();
		}
		while (sc.hasNext()) {
			String s = sc.nextLine();
			if(person.get(s) != null) {
				System.out.println(s+"="+person.get(s));
			}else {
				System.out.println("Not found");
			}
		}
		sc.close();
	}
}
