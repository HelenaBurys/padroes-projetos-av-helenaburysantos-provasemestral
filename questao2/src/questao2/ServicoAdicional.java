package questao2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ServicoAdicional implements ComponenteFatura {
    private final ComponenteFatura faturaDecorada;

    protected ServicoAdicional(ComponenteFatura faturaDecorada) {
        if (faturaDecorada == null) {
            throw new IllegalArgumentException("A fatura a decorar e obrigatoria.");
        }
        this.faturaDecorada = faturaDecorada;
    }

    protected abstract String getDescricaoServico();

    protected abstract double calcularCusto(double valorVenda);

    @Override
    public final List<ItemFatura> obterItens() {
        List<ItemFatura> itens = new ArrayList<>(this.faturaDecorada.obterItens());
        itens.add(new ItemFatura(getDescricaoServico(), calcularCusto(this.faturaDecorada.getValorVenda())));
        return Collections.unmodifiableList(itens);
    }

    @Override
    public final double getValorVenda() {
        return this.faturaDecorada.getValorVenda();
    }
}
