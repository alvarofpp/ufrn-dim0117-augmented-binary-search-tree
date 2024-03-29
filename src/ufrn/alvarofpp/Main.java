package ufrn.alvarofpp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Arquivo para testes
        final String FILENAME = "/home/roleta/IdeaProjects/edb2-trabalho-abb/src/ufrn/alvarofpp/input/input1.txt";
        // Objeto para chamarmos os comandos da árvore
        BinarySearchTree bst = new BinarySearchTree();
        // Nó que conterá a raiz
        NodeBST node = null, nodeOther;
        // Valores que usaremos para gerar a árvore
        BufferedReader buffer = null;

        try {
            // Buffer de leitura
            buffer = new BufferedReader(new FileReader(FILENAME));
            // Valores salvos no arquivo
            int valores[] = Arrays.asList(buffer.readLine().split(" "))
                    .stream()
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // Gerando a árvore
            for(int valor : valores) {
                nodeOther = new NodeBST(valor);
                node = bst.insercao(node, nodeOther);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Inicial: (");
        bst.toString(node);
        System.out.println(" )");

        System.out.print("Inserindo novo elemento: (");
        node = bst.insercao(node, new NodeBST(22));
        bst.toString(node);
        System.out.println(" )");

        System.out.print("Removendo elemento: (");
        node = bst.remocao(node, 22);
        bst.toString(node);
        System.out.println(" )");

        System.out.print("Removendo elemento que não existe: (");
        node = bst.remocao(node, 22);
        bst.toString(node);
        System.out.println(" )");

        System.out.println("É cheia: " + (bst.ehCheia(node)?"SIM":"NÃO"));

        System.out.println("contarNodesLados: ");
        bst.contarNodesLados(node);
        bst.imprimirNodesLados(node);
    }
}
