
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author alexandre
 */
public class Main {
    
    private static boolean expressaoInvalida = false;
    private static boolean divisaoPorZero = false;
    private static int contagemElementosTratados = 0;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String linha;
        
        while ((linha = input.readLine()) != null) {
            String[] elementos = linha.split(" ");
            
            expressaoInvalida = false;
            divisaoPorZero = false;
            contagemElementosTratados = 0;
            
            // obtém o primeiro elemento. se for operando, encerra com o valor deste. se for operador, obtém outros dois operandos.
            int valor = obtemProximoElemento(elementos);
            
            if (contagemElementosTratados < elementos.length)
                expressaoInvalida = true;
            
            if (expressaoInvalida)
                System.out.println("Invalid expression.");
            else if (divisaoPorZero)
                System.out.println("Division by zero.");
            else
                System.out.printf("The answer is %d.\n", valor);
        }
    }

    private static int obtemProximoElemento(String[] elementos) {
        int indice = contagemElementosTratados;
        if (indice >= elementos.length) {
            expressaoInvalida = true;
            return 0;
        }
        
        contagemElementosTratados++;
        
        if (elementos[indice].equals("+") || elementos[indice].equals("-") || elementos[indice].equals("*") || elementos[indice].equals("/")) {
            // operador
            String operador = elementos[indice];
            
            // obtém um operando
            int umOperando = obtemProximoElemento(elementos);
            if (expressaoInvalida)
                return 0;
            
            // obtém outro operando
            int outroOperando = obtemProximoElemento(elementos);
            if (expressaoInvalida)
                return 0;
            
            // calcula resultado
            switch (operador.charAt(0)) {
                case '+':
                    return outroOperando + umOperando;
                case '-':
                    return outroOperando - umOperando;
                case '*':
                    return outroOperando * umOperando;
                case '/':
                    if (umOperando != 0)
                        return outroOperando / umOperando;
                    else {
                        divisaoPorZero = true;
                        return 0;
                    }
            }
            
        } else if (elementos[indice].length() == 1 && elementos[indice].charAt(0) >= '0' && elementos[indice].charAt(0) <= '9') {
            int operando = Integer.parseInt(elementos[indice]);
            return operando;
        } else {
            expressaoInvalida = true;
            return 0;
        }
        return 0;
    }
    
}
