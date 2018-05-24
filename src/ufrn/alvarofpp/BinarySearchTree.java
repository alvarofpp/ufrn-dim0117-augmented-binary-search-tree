package ufrn.alvarofpp;

public class BinarySearchTree {

    /**
     * Procura o Nó na árvore
     *
     * @param node Nó usado para percorrer a árvore (inicialmente é a raiz)
     * @param conteudo Conteúdo que se usa para encontrar o nó
     * @return Nó desejado ou null caso não tenha encontrado
     */
    public NodeBST busca(NodeBST node, int conteudo) {
        if (node == null || node.getConteudo() == conteudo) {
            return node;
        } else if (node.getEsq() != null && node.getConteudo() > conteudo) {
            return this.busca(node.getEsq(), conteudo);
        } else {
            return this.busca(node.getDir(), conteudo);
        }
    }

    /**
     * Insere um novo nó na árvore
     *
     * @param node Inicialmente é a raiz
     * @param nodeNew Nó que se deseja inserir
     * @return Nó raiz
     */
    public NodeBST insercao(NodeBST node, NodeBST nodeNew) {
        // Para a inserção do primeiro elemento na árvore
        if (node == null) {
            return nodeNew;
        }

        // Garante que não se tenha elementos duplicados
        if (node.getConteudo() == nodeNew.getConteudo()) {
            return node;
        }

        if (node.getConteudo() > nodeNew.getConteudo()) {
            node.setEsq(this.insercao(node.getEsq(), nodeNew));
        } else {
            node.setDir(this.insercao(node.getDir(), nodeNew));
        }

        return node;
    }

    /**
     * Remove o nó da árvore
     *
     * @param node Nó que se deseja remover
     * @param conteudo Conteudo da árvore que se deseja remover
     * @return Nó raiz
     */
    public NodeBST remocao(NodeBST node, int conteudo) {
        // Ignora a remoção de um elemento que não existe
        if (node == null) {
            return null;
        }

        // Caso se deseje remover a raiz
        if (node.getConteudo() == conteudo) {
            NodeBST p, q;

            if (node.getEsq() == null ) {
                return node.getDir();
            }

            p = node;
            q = node.getEsq();
            while (q.getDir() != null) {
                p = q;
                q = q.getDir();
            }

            if (p != node) {
                p.setDir(q.getEsq());
                q.setEsq(node.getEsq());
            }

            q.setDir(node.getDir());

            return q;
        } else if (node.getConteudo() < conteudo) {
            node.setDir(this.remocao(node.getDir(), conteudo));
        } else {
            node.setEsq(this.remocao(node.getEsq(), conteudo));
        }

        return node;
    }

    public int contarNodesLados(NodeBST node) {
        // Se não for um nó válido
        if (node == null) {
            return 0;
        }

        // Se for um nó final
        if ((node.getEsq() == null) && (node.getDir() == null)) {
            return 1;
        }

        node.setQtdeEsq(this.contarNodesLados(node.getEsq()));
        node.setQtdeDir(this.contarNodesLados(node.getDir()));

        return (node.getQtdeEsq() + node.getQtdeDir() + 1);
    }

    public void imprimirNodesLados(NodeBST node) {
        if (node == null) {
            return;
        }

        this.imprimirNodesLados(node.getEsq());
        System.out.println(node.getQtdeEsq() + " <- " + node.getConteudo() + " -> " + node.getQtdeDir());
        this.imprimirNodesLados(node.getDir());
    }

    /**
     * Imprime a árvore por ordem simétrica
     *
     * @param node Inicialmente é o nó raiz
     */
    public void toString(NodeBST node) {
        if (node == null) {
            return;
        }

        if (node.getEsq() == null && node.getDir() == null) {
            System.out.print(" " + node.getConteudo());
            return;
        }

        this.toString(node.getEsq());
        System.out.print(" " + node.getConteudo());
        this.toString(node.getDir());
    }

    /**
     * Verifica se a árvore é cheia ou não
     *
     * @param node
     * @return
     */
    public boolean ehCheia(NodeBST node) {
        // Se for uma árvore vazia
        if (node == null) {
            return true;
        }

        // Se for folha
        if ((node.getEsq() == null) && (node.getDir() == null)) {
            return true;
        }

        // Se tiver subarvores
        if ((node.getEsq() != null) && (node.getDir() != null)) {
            return ((this.ehCheia(node.getEsq())) && (this.ehCheia(node.getDir())));
        }

        return false;
    }

}
