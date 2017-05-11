
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int a, b;
        a = entrada.nextInt();
        b = entrada.nextInt();

        int maiorAB = maiorAB(a, b);
        
        a = maiorAB;
        b = entrada.nextInt();
        
        maiorAB = maiorAB(a, b);
        
        System.out.printf("%d eh o maior\n", maiorAB);
    }
    
    public static int maiorAB(int a, int b) {
        return (a + b + Math.abs(a - b)) / 2;
    }
    
}
