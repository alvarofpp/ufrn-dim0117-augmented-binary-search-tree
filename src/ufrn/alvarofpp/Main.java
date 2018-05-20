package ufrn.alvarofpp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Objeto para chamarmos os comandos da árvore
        BinarySearchTree bst = new BinarySearchTree();
        // Nó que conterá a raiz
        NodeBST node = null, nodeOther;
        // Valores que usaremos para gerar a árvore
        BufferedReader buffer = null;

        try {
            buffer = new BufferedReader(new FileReader("/home/roleta/IdeaProjects/edb2-trabalho-abb/src/ufrn/alvarofpp/input/input1.txt"));

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


        System.out.print("(");
        bst.toString(node);
        System.out.print(" )");
    }
}
