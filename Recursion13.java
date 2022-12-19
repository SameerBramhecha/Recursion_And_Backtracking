import java.util.ArrayList;

/*
Print all subsets of a set of first n natural numbers
*/
public class Recursion13 {
    public static void findSubsets(int n, ArrayList<Integer> subSet) {

        if (n == 0) {
            printSubset(subSet);
            return;
        }

        // add
        subSet.add(n);
        findSubsets(n - 1, subSet);

        // not added
        subSet.remove(subSet.size() - 1);
        findSubsets(n - 1, subSet);
    }

    public static void printSubset(ArrayList<Integer> subSet) {
        for (int i = 0; i < subSet.size(); i++) {
            System.out.print(subSet.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;
        ArrayList<Integer> subSet = new ArrayList<>();
        findSubsets(n, subSet);
    }
}
