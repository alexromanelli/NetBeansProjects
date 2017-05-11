
import java.util.Scanner;

/**
 *
 * @author alexandre
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double valor = input.nextDouble();
        
        int parteInteira = (int) Math.floor(valor);
        int parteFracionaria = (int) Math.floor((valor - parteInteira) * 100);
        
        int notasDe100 = parteInteira / 100;
        parteInteira %= 100;
        int notasDe50 = parteInteira / 50;
        parteInteira %= 50;
        int notasDe20 = parteInteira / 20;
        parteInteira %= 20;
        int notasDe10 = parteInteira / 10;
        parteInteira %= 10;
        int notasDe5 = parteInteira / 5;
        parteInteira %= 5;
        int notasDe2 = parteInteira / 2;
        parteInteira %= 2;
        int moedasDe1 = parteInteira;
        
        int moedasDe50c = 0, moedasDe25c = 0, moedasDe10c = 0, moedasDe5c = 0, moedasDe1c = 0;
        if (parteFracionaria >= 50) {
            moedasDe50c = 1;
            parteFracionaria -= 50;
        }
        if (parteFracionaria >= 25) {
            moedasDe25c = 1;
            parteFracionaria -= 25;
        }
        if (parteFracionaria >= 10) {
            moedasDe10c = parteFracionaria / 10;
            parteFracionaria -= 10 * moedasDe10c;
        }
        if (parteFracionaria >= 5) {
            moedasDe5c = 1;
            parteFracionaria -= 5;
        }
        moedasDe1c = parteFracionaria;
        
        System.out.println("NOTAS:");
        System.out.printf("%d nota(s) de R$ 100.00\n", notasDe100);
        System.out.printf("%d nota(s) de R$ 50.00\n", notasDe50);
        System.out.printf("%d nota(s) de R$ 20.00\n", notasDe20);
        System.out.printf("%d nota(s) de R$ 10.00\n", notasDe10);
        System.out.printf("%d nota(s) de R$ 5.00\n", notasDe5);
        System.out.printf("%d nota(s) de R$ 2.00\n", notasDe2);
        System.out.println("MOEDAS:");
        System.out.printf("%d moeda(s) de R$ 1.00\n", moedasDe1);
        System.out.printf("%d moeda(s) de R$ 0.50\n", moedasDe50c);
        System.out.printf("%d moeda(s) de R$ 0.25\n", moedasDe25c);
        System.out.printf("%d moeda(s) de R$ 0.10\n", moedasDe10c);
        System.out.printf("%d moeda(s) de R$ 0.05\n", moedasDe5c);
        System.out.printf("%d moeda(s) de R$ 0.01\n", moedasDe1c);
    }
    
}
