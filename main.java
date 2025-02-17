// Print Table in reverse Order Using While loop

import java.util.*;

public class main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        // Inputm the number for which the table is to be printed
        System. out.print("Enter the number: ");
        int num = sc.nextInt();

        // Initialize the counter to 10 (default range)
         int i = 10;

        // Loop to print the table in reverse order
        while (i >= 1) {
            System.out.println(num + " * " + i + " = " + (num * i));
            i--; // Decrement the counter
        }
    }
}