package ufrn.alvarofpp;

public class BinarySearchTree {

    public NodeBST busca(NodeBST node, int key) {
        if (node == null || node.getChave() == key) {
            return node;
        } else if (node.getEsq() != null && node.getChave() > key) {
            return this.busca(node.getEsq(), key);
        } else {
            return this.busca(node.getDir(), key);
        }
    }

    public NodeBST insercao(NodeBST node, NodeBST nodeNew) {
        if (node == null) {
            return nodeNew;
        }

        if (node.getChave() > nodeNew.getChave()) {
            node.setEsq(this.insercao(node.getEsq(), nodeNew));
        } else {
            node.setDir(this.insercao(node.getDir(), nodeNew));
        }

        return node;
    }

}
