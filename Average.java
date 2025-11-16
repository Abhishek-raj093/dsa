import java.util.*;

public class average {
    public static void main(Strings[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int m = b;
        int sum = 0;
//Change

        while (m>0){
            int num = sc.nextInt();
            sum = sum + num;
            m--;
        }
        System.out.println(sum/b);
    }
}

