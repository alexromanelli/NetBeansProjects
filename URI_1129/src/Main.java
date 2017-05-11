
import java.util.Scanner;

/**
 *
 * @author alexandre
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        while (n != 0) {
            for (int resp = 0; resp < n; resp++) {
                int resposta = 0;
                boolean anulada = false;
                for (int i = 1; i <= 5; i++) {
                    int media = input.nextInt();
                    if (anulada)
                        continue;
                    if (media <= 127 && resposta == 0)
                        resposta = i;
                    else if (media <= 127 && resposta != 0) {
                        resposta = 0;
                        anulada = true;
                    }
                }
                if (resposta == 0)
                    System.out.println("*");
                else {
                    char r = (char)((int)'A' + resposta - 1);
                    System.out.println(r);
                }
            }
            
            n = input.nextInt();
        }
    }
    
}
