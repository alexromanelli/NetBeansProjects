/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleobi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author alexandre
 */
public class ControleOBI {

    public static Modalidade lerModalidade(BufferedReader input) throws IOException {
        System.out.println("Registro de modalidade");
        System.out.print(" - Código...: ");
        int codigo = Integer.parseInt(input.readLine());
        System.out.print(" - Nome.....: ");
        String nome = input.readLine();
        System.out.print(" - Descrição: ");
        String descricao = input.readLine();
        
        Modalidade m = new Modalidade(codigo, nome, descricao);
        return m;
    }
    
    public static void imprimirModalidade(Modalidade m) {
        System.out.println(" - Código...: " + m.getCodigo());
        System.out.println(" - Nome.....: " + m.getNome());
        System.out.println(" - Descrição: " + m.getDescricao());
    }
    
    public static void imprimirCabecalhoTabela() {
        System.out.println("+--------+------------------+--------------------------------+");
        System.out.println("| Código | Nome             | Descrição                      |");
        System.out.println("+--------+------------------+--------------------------------+");
    }
    
    public static void imprimirRodapeTabela() {
        System.out.println("+--------+------------------+--------------------------------+");
    }
    
    public static void imprimirModalidadeTabela(Modalidade m) {
        System.out.printf("| %6d | %-16s | %-30s |\n",
                m.getCodigo(), m.getNome(), m.getDescricao());
    }
    
    public static void alterarModalidade(Modalidade m, BufferedReader input) throws IOException {
        System.out.println("Alteração de registro de modalidade");
        System.out.println(" - Código...: " + m.getCodigo());
        System.out.print("   - Alterar código (s/n)? ");
        String opcao = input.readLine();
        if (opcao.equals("s")) {
            System.out.print("   - Novo código: ");
            int novoCodigo = Integer.parseInt(input.readLine());
            m.setCodigo(novoCodigo);
        }
        System.out.println(" - Nome.....: " + m.getNome());
        System.out.print("   - Alterar nome (s/n)? ");
        opcao = input.readLine();
        if (opcao.equals("s")) {
            System.out.print("   - Novo nome: ");
            String novoNome = input.readLine();
            m.setNome(novoNome);
        }
        System.out.println(" - Descrição: " + m.getDescricao());
        System.out.print("   - Alterar descrição (s/n)? ");
        opcao = input.readLine();
        if (opcao.equals("s")) {
            System.out.print("   - Nova descrição: ");
            String novaDescricao = input.readLine();
            m.setDescricao(novaDescricao);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<Modalidade> listaModalidades = new ArrayList<>();
        
        int opcao = 1;
        while (opcao != 5) { // opcao == 5 -> Sair
            // exibir menu
            System.out.println();
            System.out.println("Opções:");
            System.out.println(" 1. Inserir modalidade;");
            System.out.println(" 2. Alterar modalidade;");
            System.out.println(" 3. Excluir modalidade;");
            System.out.println(" 4. Listar modalidade;");
            System.out.println(" 5. Sair do programa.");
            System.out.print("Digite o número da opção desejada e tecle Enter: ");
            opcao = Integer.parseInt(input.readLine());
            
            switch (opcao) {
                case 1:
                    Modalidade m = lerModalidade(input);
                    listaModalidades.add(m);
                    break;
                case 2:
                    System.out.print("Informe o código da modalidade a alterar: ");
                    int codigo = Integer.parseInt(input.readLine());
                    m = null;
                    for (int i = 0; i < listaModalidades.size(); i++) {
                        Modalidade m1 = listaModalidades.get(i);
                        if (codigo == m1.getCodigo()) {
                            m = m1;
                            break;
                        }
                    }
                    if (m == null) {
                        System.out.println("CÓDIGO NÃO ENCONTRADO!");
                    } else {
                        alterarModalidade(m, input);
                    }
                    break;
                case 3:
                    System.out.print("Informe o código da modalidade a excluir: ");
                    codigo = Integer.parseInt(input.readLine());
                    boolean excluido = false;
                    for (int i = 0; i < listaModalidades.size(); i++) {
                        if (codigo == listaModalidades.get(i).getCodigo()) {
                            listaModalidades.remove(i);
                            excluido = true;
                            break;
                        }
                    }
                    if (!excluido)
                        System.out.println("CÓDIGO NÃO ENCONTRADO!");
                    break;
                case 4:
                    imprimirCabecalhoTabela();
                    for (Modalidade modalidade : listaModalidades) {
                        imprimirModalidadeTabela(modalidade);
                    }
                    imprimirRodapeTabela();
                    break;
                default:
                    if (opcao != 5) {
                        System.out.println("OPÇÃO INVÁLIDA!");
                    }
            }
        }
    }
    
    
}
