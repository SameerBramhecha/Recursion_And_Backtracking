/* 
Count total paths in a maze from (0,0) to (n,m)
*/

public class Recursion10 {
    public static int countPaths(int i, int j, int n, int m) {
        if (i == n || j == m) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        // move downwards
        int downpaths = countPaths(i + 1, j, n, m);
        // move rightwards
        int rightpaths = countPaths(i, j + 1, n, m);

        return (downpaths + rightpaths);
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println(countPaths(0, 0, n, m));
    }
}