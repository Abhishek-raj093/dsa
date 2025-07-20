import java.util.Scanner;

public class mintomax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();  // Read number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];

            int min = Integer.MAX_VALUE, count = 0;

            // Read array and find the minimum element & its count
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();

                if (a[i] < min) {
                    min = a[i];
                    count = 1;  // Reset count when a new minimum is found
                } else if (a[i] == min) {
                    count++;  // Increase count for duplicate minimums
                }
            }

            // Print the number of elements not equal to the minimum
            System.out.println(n - count);
        }

        scanner.close();
    }
}

