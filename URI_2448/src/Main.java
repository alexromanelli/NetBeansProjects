
import java.util.Scanner;
import java.util.TreeMap;


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
        int m = input.nextInt();
        
        // criar estrutura para armazenar as associações entre números de casas e suas respectivas posições na rua
        TreeMap<Integer, Integer> arvoreNumerosCasas = new TreeMap<>();
        
        // ler números de casas e armazenar na árvore
        for (int i = 0; i < n; i++) {
            int numeroCasa = input.nextInt();
            arvoreNumerosCasas.put(numeroCasa, i);
        }
        
        // calcular o tempo gasto para percorrer as casas
        int tempo = 0;
        int posicaoAnterior = 0;
        for (int i = 0; i < m; i++) {
            int numeroCasa = input.nextInt();
            int posicaoAtual = arvoreNumerosCasas.get(numeroCasa);
            tempo += (int)Math.abs(posicaoAtual - posicaoAnterior);
            posicaoAnterior = posicaoAtual;
        }
        
        // escreve saída
        System.out.println(tempo);
    }
    
}
