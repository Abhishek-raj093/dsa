import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] d = new int[n];
            
            for (int i = 0; i < n; i++) {
                d[i] = scanner.nextInt();
            }
            
            boolean isNonDecreasing = true;
            for (int i = 1; i < n; i++) {
                if (d[i] < d[i - 1]) {
                    isNonDecreasing = false;
                    break;
                }
            }

            System.out.println(isNonDecreasing ? "Yes" : "No");
        }
        scanner.close();
    }
}
