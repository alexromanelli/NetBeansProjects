
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
    
    private static int[] ref; // outra opção?

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
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
        
        ref = new int[n];
        
        boolean[][] gerenciado = new boolean[n][n];
        for (int g = 0; g < m; g++) {
            String[] gs = input.readLine().split(" ");
            int x = Integer.parseInt(gs[0]);
            int y = Integer.parseInt(gs[1]);
            gerenciado[y - 1][x - 1] = true; // y é gerenciado por x
        }
        
        boolean[] visitado = new boolean[n];
        int[] idadeMinimaGerenteRegistrada = new int[n];
        for (int j = 0; j < n; j++) {
            visitado[j] = false;
            idadeMinimaGerenteRegistrada[j] = 101;
        }
        
        for (int instrucao = 0; instrucao < i; instrucao++) {
            String[] comandos = input.readLine().split(" ");
            switch (comandos[0].charAt(0)) {
                case 'T':
                    int a = Integer.parseInt(comandos[1]);
                    int b = Integer.parseInt(comandos[2]);
                    // troca gerências (colunas a-1 e b-1 da matriz gerenciado; linhas a-1 e b-1 da mesma matriz)
                    for (int gi = 0; gi < n; gi++) {
                        // colunas
                        boolean gc = gerenciado[gi][a - 1];
                        gerenciado[gi][a - 1] = gerenciado[gi][b - 1];
                        gerenciado[gi][b - 1] = gc;
                    }
                    for (int gj = 0; gj < n; gj++) {
                        // linhas
                        boolean gl = gerenciado[a - 1][gj];
                        gerenciado[a - 1][gj] = gerenciado[b - 1][gj];
                        gerenciado[b - 1][gj] = gl;
                    }
                    // reiniciar flags de visitas
                    for (int j = 0; j < n; j++) {
                        visitado[j] = false;
                        idadeMinimaGerenteRegistrada[j] = 101;
                    }
                    break;
                case 'P':
                    int e = Integer.parseInt(comandos[1]);
                    // fazer percurso no grafo...
                    int idadeMinima = percorreGrafo_ObtemGerenteIdadeMinima(gerenciado, e - 1, n, idades, visitado, idadeMinimaGerenteRegistrada);
                    if (idadeMinima <= 100)
                        System.out.println(idadeMinima);
                    else
                        System.out.println("*");
                    break;
            }
        }
    }
    
    private static int percorreGrafo_ObtemGerenteIdadeMinima(boolean[][] gerenciado, int indEmpregado, int n, int[] idades, boolean[] visitado, int[] idadesMinimas) {
        if (visitado[indEmpregado])
            return idadesMinimas[indEmpregado];
        
        int idadeMinimaGerente = 101;
        
        visitado[indEmpregado] = true;

        for (int i = 0; i < n; i++) {
            if (gerenciado[indEmpregado][i]) {
                int idadeGerenteDireto = idades[i];
                if (idadeMinimaGerente > idadeGerenteDireto)
                    idadeMinimaGerente = idadeGerenteDireto;
                
                int idadeMinimaGerenteIndireto = visitado[i] ? idadesMinimas[i] : 
                        percorreGrafo_ObtemGerenteIdadeMinima(gerenciado, i, n, idades, visitado, idadesMinimas);
                
                if (idadeMinimaGerente > idadeMinimaGerenteIndireto)
                    idadeMinimaGerente = idadeMinimaGerenteIndireto;
            }
        }

        idadesMinimas[indEmpregado] = idadeMinimaGerente;
        return idadeMinimaGerente;
    }
    
}
