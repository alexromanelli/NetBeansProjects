
import java.util.Scanner;

/**
 *
 * @author alexandre
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] floresta = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                floresta[i][j] = input.nextInt();
            }
        }
        
        boolean[] especieEncontrada = new boolean[1000];
        
        for (int i = 0; i < n * 2; i++) {
            int linha = input.nextInt();
            int coluna = input.nextInt();
            
            int especie = floresta[linha - 1][coluna - 1];
            especieEncontrada[especie - 1] = true;
        }
        
        int quantidadeEspeciesEncontradas = 0;
        for (int i = 0; i < 1000; i++) {
            if (especieEncontrada[i]) {
                quantidadeEspeciesEncontradas++;
            }
        }
        
        System.out.println(quantidadeEspeciesEncontradas);
    }
    
}
