import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);

        // n (the initial number of elements in list).
        int n = sc.nextInt();

        // The second line contains N space-separated integers describing L .
        List<Integer> list = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        // The third line contains an integer, Q (the number of queries).
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            //subsequent lines describe the queries, and each query is described
            String operation = sc.next();
            if ("Insert".equalsIgnoreCase(operation)) {
                int index = sc.nextInt();
                int value = sc.nextInt();

                list.add(index, value);
            }

            else if ("Delete".equalsIgnoreCase(operation)) {
                int index = sc.nextInt();
                list.remove(index);
            }
        }

        for (int element : list){
            System.out.print(element + " ");
        }
        sc.close();
    }
}
