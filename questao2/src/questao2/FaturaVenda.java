package questao2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FaturaVenda implements ComponenteFatura {
    private final String nomeLote;
    private final double valorVenda;

    public FaturaVenda(Lote lote) {
        if (lote == null || !lote.isVendido()) {
            throw new IllegalArgumentException("A fatura exige um lote vendido.");
        }
        this.nomeLote = lote.getNome();
        this.valorVenda = lote.getMaiorLance();
    }

    @Override
    public List<ItemFatura> obterItens() {
        List<ItemFatura> itens = new ArrayList<>();
        itens.add(new ItemFatura("Lote: " + this.nomeLote, this.valorVenda));
        return Collections.unmodifiableList(itens);
    }

    @Override
    public double getValorVenda() {
        return this.valorVenda;
    }
}
