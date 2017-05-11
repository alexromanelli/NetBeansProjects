/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudobasicojava;

import java.util.Scanner;

/**
 *
 * @author alexandre
 */
public class EstudoBasicoJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada;
        entrada = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        long x = entrada.nextLong();
        System.out.print("Digite outro número inteiro: ");
        long y = entrada.nextLong();

        long p = 0;
        

        for (int i = 0; i < y; i++)
            p = p + x;
        
//        if (z > 0) {
//            do {
//                p = p + x;
//                z = z - 1;
//            } while (z > 0);
//        }

        System.out.printf("%d * %d = %d\n", x, y, p);
    }

}
