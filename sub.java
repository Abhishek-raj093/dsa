public class sub {
    int x = 10;
    int y = 5;
    
    try {
         int result = Math.subtractExact(x, y);
         System.out.println("Result: " + result);
    } catch (ArithmeticException e) {
        System.out.println("Overflow occurred during subtraction.");
    }
}
