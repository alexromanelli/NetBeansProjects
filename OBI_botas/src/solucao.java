
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Se for usar este código, cite o autor.
 */

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class solucao {
    
    private static final int INDICE_LADO_DIREITO = 0;
    private static final int INDICE_LADO_ESQUERDO = 1;
    private static final int INICIO_NUMERACAO = 30;
    private static final int QUANTIDADE_NUMEROS_POSSIVEIS = 31;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        int[][] botas = new int[2][QUANTIDADE_NUMEROS_POSSIVEIS];
        for (int i = 0; i < n; i++) {
            String linha = input.readLine();
            String[] valores = linha.split(" ");
            int m = Integer.parseInt(valores[0]);
            char l = valores[1].charAt(0);
            
            int indLado = l == 'D' ? INDICE_LADO_DIREITO : INDICE_LADO_ESQUERDO;
            int indNumeracao = m - INICIO_NUMERACAO;
            botas[indLado][indNumeracao]++;
        }
        
        int quantidadePares = 0;
        for (int i = 0; i < QUANTIDADE_NUMEROS_POSSIVEIS; i++) {
            int paresNumeroI = (int)Math.min(botas[INDICE_LADO_DIREITO][i], botas[INDICE_LADO_ESQUERDO][i]);
            quantidadePares += paresNumeroI;
        }
        
        System.out.println(quantidadePares);
    }
    
}
