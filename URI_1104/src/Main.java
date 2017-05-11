
import java.util.Scanner;

/**
 *
 * @author alexandre
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        while (a != 0 && b != 0) {
            // ler cartas de Alice, contando repetidas
            int[] cartasA = new int[a];
            int repetidas = 0;
            for (int i = 0; i < a; i++) {
                cartasA[i] = input.nextInt();
                if (i > 0 && cartasA[i] == cartasA[i-1])
                    repetidas++;
            }
            
            // montar conjunto de cartas de Alice, retirando repetidas
            int[] conjuntoA = new int[a - repetidas];
            conjuntoA[0] = cartasA[0];
            int ind = 1;
            for (int i = 1; i < a; i++) {
                if (cartasA[i] != cartasA[i - 1])
                    conjuntoA[ind++] = cartasA[i];
            }
            
            // ler cartas de Beatriz, contando repetidas
            int[] cartasB = new int[b];
            repetidas = 0;
            for (int i = 0; i < b; i++) {
                cartasB[i] = input.nextInt();
                if (i > 0 && cartasB[i] == cartasB[i-1])
                    repetidas++;
            }
            
            // montar conjunto de cartas de Beatriz, retirando repetidas
            int[] conjuntoB = new int[b - repetidas];
            conjuntoB[0] = cartasB[0];
            ind = 1;
            for (int i = 1; i < b; i++) {
                if (cartasB[i] != cartasB[i - 1])
                    conjuntoB[ind++] = cartasB[i];
            }
            
            // contar cartas de Alice que Beatriz não tem
            int exclA = 0;
            for (int i = 0; i < conjuntoA.length; i++) {
                boolean tem = false;
                for (int j = 0; j < conjuntoB.length; j++) {
                    if (conjuntoB[j] == conjuntoA[i]) {
                        tem = true;
                        break;
                    }
                    if (conjuntoB[j] > conjuntoA[i]) {
                        break;
                    }
                }
                if (!tem)
                    exclA++;
            }
            
            // contar cartas de Beatriz que Alice não tem
            int exclB = 0;
            for (int i = 0; i < conjuntoB.length; i++) {
                boolean tem = false;
                for (int j = 0; j < conjuntoA.length; j++) {
                    if (conjuntoA[j] == conjuntoB[i]) {
                        tem = true;
                        break;
                    }
                    if (conjuntoA[j] > conjuntoB[i]) {
                        break;
                    }
                }
                if (!tem)
                    exclB++;
            }
            
            System.out.println(exclA < exclB ? exclA : exclB);
            
            a = input.nextInt();
            b = input.nextInt();
        }
    }
    
}
