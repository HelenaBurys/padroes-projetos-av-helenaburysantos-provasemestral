package questao2;

public class ItemFatura {
    private final String descricao;
    private final double valor;

    public ItemFatura(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getValor() {
        return this.valor;
    }
}
