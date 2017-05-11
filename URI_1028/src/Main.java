
import java.util.Scanner;

/**
 *
 * @author alexandre
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int f1 = input.nextInt();
            int f2 = input.nextInt();
            while (f2 != 0) {
                int r = f1 % f2;
                f1 = f2;
                f2 = r;
            }
            System.out.println(f1);
        }
    }
    
}
