/*
Place tiles of 1xm in a floor of size nxm
*/
public class Recursion11 {
    public static int placeTiles(int n, int m) {

        if (n == m) {
            return 2;
        }
        if (n < m) {
            return 1;
        }

        // vertically
        int vertical = placeTiles(n - m, m);
        // horizontally
        int horizontal = placeTiles(n - 1, m);
        return (vertical + horizontal);
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        System.out.println(placeTiles(n, m));
    }
}
