package ufrn.alvarofpp;

public class BinarySearchTree {

    public NodeBST busca(NodeBST node, int key) {
        if (node == null || node.getConteudo() == key) {
            return node;
        } else if (node.getEsq() != null && node.getConteudo() > key) {
            return this.busca(node.getEsq(), key);
        } else {
            return this.busca(node.getDir(), key);
        }
    }

    public NodeBST insercao(NodeBST node, NodeBST nodeNew) {
        if (node == null) {
            return nodeNew;
        }

        if (node.getConteudo() > nodeNew.getConteudo()) {
            node.setEsq(this.insercao(node.getEsq(), nodeNew));
        } else {
            node.setDir(this.insercao(node.getDir(), nodeNew));
        }

        return node;
    }

    public NodeBST remocao(NodeBST node) {
        NodeBST p, q;
        if (node.getEsq() == null ) {
            q = node.getDir();
            return q;
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
    }

    public void toString(NodeBST node) {
        if (node == null) {
            return;
        }

        if (node.getEsq() == null && node.getDir() == null) {
            System.out.print(" " + node.getConteudo());
            return;
        }

        this.toString(node.getEsq());
        this.toString(node.getDir());

        System.out.print(" " + node.getConteudo());
    }

}
