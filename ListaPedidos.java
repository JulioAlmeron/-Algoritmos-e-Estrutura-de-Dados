public class ListaPedidos implements IEstruturaDinamica {
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public ListaPedidos() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public void inserirElemento(Object elemento) {
        No novo = new No(elemento);
        if (estaVazia()) {
            primeiro = ultimo = novo;
        } else {
            ultimo.setProx(novo);
            novo.setAnterior(ultimo);
            ultimo = novo;
        }
        tamanho++;
    }

    public void inserirSequencia(Object elementos) {
        if (elementos instanceof Object[]) {
            for (Object el : (Object[]) elementos) {
                inserirElemento(el);
            }
        }
    }

    public boolean removerElemento(Object elemento) {
        No atual = primeiro;
        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) {
                if (atual == primeiro) {
                    primeiro = atual.getProx();
                    if (primeiro != null) primeiro.setAnterior(null);
                } else if (atual == ultimo) {
                    ultimo = atual.getAnterior();
                    if (ultimo != null) ultimo.setProx(null);
                } else {
                    atual.getAnterior().setProx(atual.getProx());
                    atual.getProx().setAnterior(atual.getAnterior());
                }
                tamanho--;
                return true;
            }
            atual = atual.getProx();
        }
        return false;
    }

    public void removerSequencia(Object elementos) {
        if (elementos instanceof Object[]) {
            for (Object el : (Object[]) elementos) {
                removerElemento(el);
            }
        }
    }

    public void removerTodasOcorrencias(Object elemento) {
        while (removerElemento(elemento)) {}
    }

    public boolean estaCheia() {
        return false; // Lista dinâmica não tem limite
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean buscarElemento(Object elemento) {
        No atual = primeiro;
        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) return true;
            atual = atual.getProx();
        }
        return false;
    }

    public void ordenarCrescente() {
        for (No i = primeiro; i != null; i = i.getProx()) {
            for (No j = i.getProx(); j != null; j = j.getProx()) {
                Comparable a = (Comparable) i.getConteudo();
                Comparable b = (Comparable) j.getConteudo();
                if (a.compareTo(b) > 0) {
                    Object temp = i.getConteudo();
                    i.setConteudo(j.getConteudo());
                    j.setConteudo(temp);
                }
            }
        }
    }

    public void ordenarDecrescente() {
        for (No i = primeiro; i != null; i = i.getProx()) {
            for (No j = i.getProx(); j != null; j = j.getProx()) {
                Comparable a = (Comparable) i.getConteudo();
                Comparable b = (Comparable) j.getConteudo();
                if (a.compareTo(b) < 0) {
                    Object temp = i.getConteudo();
                    i.setConteudo(j.getConteudo());
                    j.setConteudo(temp);
                }
            }
        }
    }

    public int quantidadeElementos() {
        return tamanho;
    }

    public void editarElemento(Object antigo, Object novo) {
        No atual = primeiro;
        while (atual != null) {
            if (atual.getConteudo().equals(antigo)) {
                atual.setConteudo(novo);
                return;
            }
            atual = atual.getProx();
        }
    }

    public void limpar() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public void exibir() {
        No atual = primeiro;
        System.out.print("Pedidos: [ ");
        while (atual != null) {
            System.out.print(atual.getConteudo() + " ");
            atual = atual.getProx();
        }
        System.out.println("]");
    }

    public No obterPrimeiroElemento() {
        return primeiro;
    }

    public No obterUltimoElemento() {
        return ultimo;
    }
}
