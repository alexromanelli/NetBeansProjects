
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        String nome = entrada.nextLine();
        double salarioFixo, vendas;
        salarioFixo = entrada.nextDouble();
        vendas = entrada.nextDouble();
        
        double salario = salarioFixo + vendas * 0.15;
        
        System.out.printf("TOTAL = R$ %.2f\n", salario);
    }
    
}
