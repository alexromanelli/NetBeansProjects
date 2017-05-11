
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int a, b, c, d;
        a = entrada.nextInt();
        b = entrada.nextInt();
        c = entrada.nextInt();
        d = entrada.nextInt();
        
        int diferenca = a * b - c * d;
        System.out.printf("DIFERENCA = %d\n", diferenca);
    }
    
}
