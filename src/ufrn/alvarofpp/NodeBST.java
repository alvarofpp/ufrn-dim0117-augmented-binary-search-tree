package ufrn.alvarofpp;

public class NodeBST {
    private int conteudo;
    private NodeBST esq, dir;
    private int qtdeEsq, qtdeDir;

    public NodeBST(int conteudo) {
        this.conteudo = conteudo;
        this.esq = null;
        this.dir = null;
        this.qtdeEsq = 0;
        this.qtdeDir = 0;
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

    public int getQtdeEsq() {
        return qtdeEsq;
    }

    public void setQtdeEsq(int qtdeEsq) {
        this.qtdeEsq = qtdeEsq;
    }

    public int getQtdeDir() {
        return qtdeDir;
    }

    public void setQtdeDir(int qtdeDir) {
        this.qtdeDir = qtdeDir;
    }
}
