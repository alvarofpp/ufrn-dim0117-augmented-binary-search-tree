package ufrn.alvarofpp;

public class NodeBST {
    private int conteudo;
    private NodeBST esq, dir;

    public NodeBST(int conteudo) {
        this.conteudo = conteudo;
        this.esq = null;
        this.dir = null;
    }

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    public NodeBST getEsq() {
        return esq;
    }

    public void setEsq(NodeBST esq) {
        this.esq = esq;
    }

    public NodeBST getDir() {
        return dir;
    }

    public void setDir(NodeBST dir) {
        this.dir = dir;
    }
}
