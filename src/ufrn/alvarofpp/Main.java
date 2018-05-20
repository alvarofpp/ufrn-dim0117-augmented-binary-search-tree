package ufrn.alvarofpp;

public class Main {

    public static void main(String[] args) {
        // Valores que usaremos para gerar a árvore
        // int valores[] = {5, 11, 12, 14, 15, 18, 19, 21, 23, 25, 27, 28, 30, 32, 37};
        int valores[] = {50, 30, 70, 20, 40, 60, 80, 15, 25, 35, 45, 36};
        // Objeto para chamarmos os comandos da árvore
        BinarySearchTree bst = new BinarySearchTree();
        // Nó que conterá a raiz
        NodeBST node = null, nodeOther;
        // Gerando a árvore
        for(int valor : valores) {
            nodeOther = new NodeBST(valor);
            node = bst.insercao(node, nodeOther);
        }

        System.out.print("(");
        bst.toString(node);
        System.out.print(" )");
    }
}
