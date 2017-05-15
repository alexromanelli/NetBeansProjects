
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
public class chefe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] quantidades = input.readLine().split(" ");
        int n = Integer.parseInt(quantidades[0]);
        int m = Integer.parseInt(quantidades[1]);
        int i = Integer.parseInt(quantidades[2]);
        
        int[] idades = new int[n];
        String[] idadesString = input.readLine().split(" ");
        for (int ind = 0; ind < n; ind++) {
            idades[ind] = Integer.parseInt(idadesString[ind]);
        }
        
        boolean[][] gerenciado = new boolean[n][n];
        for (int g = 0; g < m; g++) {
            String[] gs = input.readLine().split(" ");
            int x = Integer.parseInt(gs[0]);
            int y = Integer.parseInt(gs[1]);
            gerenciado[y - 1][x - 1] = true; // y é gerenciado por x
        }
        
        for (int instrucao = 0; instrucao < i; instrucao++) {
            String[] comandos = input.readLine().split(" ");
            switch (comandos[0].charAt(0)) {
                case 'T':
                    int a = Integer.parseInt(comandos[1]);
                    int b = Integer.parseInt(comandos[2]);
                    // troca gerências (colunas a-1 e b-1 da matriz gerencia; linhas a-1 e b-1 da mesma matriz)
                    for (int gi = 0; gi < n; gi++) {
                        boolean g = gerenciado[gi][a - 1];
                        gerenciado[gi][a - 1] = gerenciado[gi][b - 1];
                        gerenciado[gi][b - 1] = g;
                    }
                    for (int gj = 0; gj < n; gj++) {
                        boolean g = gerenciado[a - 1][gj];
                        gerenciado[a - 1][gj] = gerenciado[b - 1][gj];
                        gerenciado[b - 1][gj] = g;
                    }
                    break;
                case 'P':
                    int e = Integer.parseInt(comandos[1]);
                    // fazer percurso no grafo...
                    int idadeMinima = percorreGrafo_ObtemGerenteIdadeMinima(gerenciado, e - 1, n, idades);
                    if (idadeMinima <= 100)
                        System.out.println(idadeMinima);
                    else
                        System.out.println("*");
                    break;
            }
        }
    }
    
    private static int percorreGrafo_ObtemGerenteIdadeMinima(boolean[][] gerenciado, int indEmpregado, int n, int[] idades) {
        int idadeMinimaGerente = 101;
        
        for (int i = 0; i < n; i++) {
            if (gerenciado[indEmpregado][i]) {
                int idadeGerenteDireto = idades[i];
                if (idadeMinimaGerente > idadeGerenteDireto)
                    idadeMinimaGerente = idadeGerenteDireto;
                
                int idadeMinimaGerenteIndireto = percorreGrafo_ObtemGerenteIdadeMinima(gerenciado, i, n, idades);
                if (idadeMinimaGerente > idadeMinimaGerenteIndireto)
                    idadeMinimaGerente = idadeMinimaGerenteIndireto;
            }
        }
        
        return idadeMinimaGerente;
    }
    
}
