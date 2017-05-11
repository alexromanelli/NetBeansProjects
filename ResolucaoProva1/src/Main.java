
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        while (a != 0 && b != 0) {
            int[] cartasAlice = new int[a];
            int[] cartasBeatriz = new int[b];
            
            int repetidasA = 0;
            for (int i = 0; i < a; i++) {
                cartasAlice[i] = input.nextInt();
                
                // conta e marca repetidas
                if (i > 0 && cartasAlice[i] == cartasAlice[i - 1]) {
                    repetidasA++;
                }
            }
            int repetidasB = 0;
            for (int i = 0; i < b; i++) {
                cartasBeatriz[i] = input.nextInt();
                
                // conta e marca repetidas
                if (i > 0 && cartasBeatriz[i] == cartasBeatriz[i - 1]) {
                    repetidasB++;
                }
            }

            // eliminar duplicatas
            int[] conjuntoA = new int[a - repetidasA];
            int[] conjuntoB = new int[b - repetidasB];
            int indA = 1;
            conjuntoA[0] = cartasAlice[0];
            for (int i = 1; i < a; i++) {
                if (cartasAlice[i] != cartasAlice[i - 1])
                    conjuntoA[indA++] = cartasAlice[i];
            }
            int indB = 1;
            conjuntoB[0] = cartasBeatriz[0];
            for (int i = 1; i < b; i++) {
                if (cartasBeatriz[i] != cartasBeatriz[i - 1])
                    conjuntoB[indB++] = cartasBeatriz[i];
            }
            
            // contar cartas de Alice que Beatriz não tem
            int cartasTrocaA = 0;
            for (int i = 0; i < conjuntoA.length; i++) {
                boolean tem = false;
                for (int j = 0; j < conjuntoB.length; j++) {
                    if (conjuntoA[i] == conjuntoB[j]) {
                        tem = true;
                        break;
                    } else if (conjuntoA[i] < conjuntoB[j]) {
                        break;
                    }
                }
                if (!tem)
                    cartasTrocaA++;
            }
            
            // contar cartas de Beatriz que Alice não tem
            int cartasTrocaB = 0;
            for (int i = 0; i < conjuntoB.length; i++) {
                boolean tem = false;
                for (int j = 0; j < conjuntoA.length; j++) {
                    if (conjuntoB[i] == conjuntoA[j]) {
                        tem = true;
                        break;
                    } else if (conjuntoB[i] < conjuntoA[j]) {
                        break;
                    }
                }
                if (!tem)
                    cartasTrocaB++;
            }
            
            // retornar a menor quantidade de cartas que uma tem e outra não
            if (cartasTrocaA < cartasTrocaB)
                System.out.println(cartasTrocaA);
            else
                System.out.println(cartasTrocaB);
            
            a = input.nextInt();
            b = input.nextInt();
        }
    }
    
}
