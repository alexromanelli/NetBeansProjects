
import java.util.Scanner;

/*
 * Se for usar este código, cite o autor.
 */

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class game10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int d = input.nextInt();
        int a = input.nextInt();
        
        int dif = 0;
        if (a < d)
            dif = d - a;
        else if (a > d)
            dif = n - a + d;
        
        System.out.println(dif);
    }
    
}
