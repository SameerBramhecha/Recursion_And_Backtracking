
// printing all subsequences whose sum is k
import java.util.*;

public class Recursion14 {
    public static void subsequences(int i, ArrayList<Integer> a, int arr[], int n, int k, int s) {
        if (i == n) {
            if (s == k) {
                for (int j = 0; j < a.size(); j++) {
                    System.out.print(a.get(j) + " ");
                }
                System.out.println();
            }
            return;
        }
        a.add(arr[i]);
        s += arr[i];
        subsequences(i + 1, a, arr, n, k, s);
        a.remove(a.size() - 1);
        s -= arr[i];
        subsequences(i + 1, a, arr, n, k, s);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1 };
        int n = arr.length;
        int k = 2;
        ArrayList<Integer> a = new ArrayList<>();
        subsequences(0, a, arr, n, k, 0);
    }
}