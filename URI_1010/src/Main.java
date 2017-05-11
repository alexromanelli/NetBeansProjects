
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int codigo = entrada.nextInt();
        int quantidade = entrada.nextInt();
        double valorUnitario = entrada.nextDouble();
        double total = quantidade * valorUnitario;
        
        codigo = entrada.nextInt();
        quantidade = entrada.nextInt();
        valorUnitario = entrada.nextDouble();
        total += quantidade * valorUnitario;
        
        System.out.printf("VALOR A PAGAR: R$ %.2f\n", total);
    }
    
}
